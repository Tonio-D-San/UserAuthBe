package it.asansonne.authhub.security;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import it.asansonne.authhub.exception.handler.AuthorizationAuthenticationHandler;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.security.provider.CustomOauth2UserService;
import it.asansonne.authhub.security.provider.UserProvisioningService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfiguration {
  private final AuthorizationAuthenticationHandler handler;
  private final CustomOauth2UserService customOAuth2UserService;
  private final ManageToken manageToken;
  private static final String LOGIN_PAGE = "/login";
  private static final String ERROR_PAGE = "/error";
  private static final String SWAGGER_URL =
      String.format("/%s/%s/swagger-ui/index.html", API, AUTH_HUB_API_VERSION);

  @Bean
  protected SecurityFilterChain filterChain(
      HttpSecurity http, KeycloakAuthenticationConverter authenticationConverter
  ) throws Exception {
    log.info("Configuring security filter chain");

    return http
        .addFilterBefore(manageToken, UsernamePasswordAuthenticationFilter.class)
        .cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .oauth2ResourceServer(oauth2 ->
            oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(authenticationConverter))
        ).authorizeHttpRequests(requests -> requests
            .requestMatchers(
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui.html"
            ).permitAll()
            .requestMatchers(
                new AntPathRequestMatcher(String.format("/%s/%s/**", API, AUTH_HUB_API_VERSION)))
            .authenticated()
            .anyRequest().permitAll()
        ).oauth2Login(oauth -> oauth
            .loginPage(LOGIN_PAGE)
            .userInfoEndpoint(userInfo -> userInfo
                .oidcUserService(customOAuth2UserService)
            ).defaultSuccessUrl(SWAGGER_URL, true)
            .permitAll()
        ).logout(logout -> logout
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
        ).sessionManagement(session -> {
              session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
              session.maximumSessions(1).maxSessionsPreventsLogin(false);
            }
        ).exceptionHandling(exceptionHandling -> exceptionHandling
            .authenticationEntryPoint((_, res, _) ->
                res.sendRedirect(ERROR_PAGE)
            ).defaultAuthenticationEntryPointFor(handler,
                new AntPathRequestMatcher(String.format("/%s/**", API)))
            .defaultAccessDeniedHandlerFor(handler,
                new AntPathRequestMatcher((String.format("/%s/**", API))))
        ).exceptionHandling(exceptionHandling -> exceptionHandling
            .authenticationEntryPoint(handler)
            .accessDeniedHandler(handler)
        ).build();
  }

  @Component
  @RequiredArgsConstructor
  protected static class KeycloakAuthenticationConverter
      implements Converter<Jwt, JwtAuthenticationToken> {
    private final KeycloakAuthoritiesConverter authoritiesConverter;
    private final UserProvisioningService userProvisioningService;

    @Override
    public JwtAuthenticationToken convert(@NonNull Jwt jwt) {
      syncUser(jwt);
      return new JwtAuthenticationToken(jwt, authoritiesConverter.convert(jwt),
          List.of(jwt.getClaimAsString(StandardClaimNames.SUB)).toString()
      );
    }

    private void syncUser(Jwt jwt) {
      String email = jwt.getClaimAsString(StandardClaimNames.EMAIL);
      if (email == null || email.isBlank()) {
        log.debug("Skipping user sync because email claim is missing for sub={}",
            jwt.getClaimAsString(StandardClaimNames.SUB));
        return;
      }

      String firstname = Optional.ofNullable(jwt.getClaimAsString(StandardClaimNames.GIVEN_NAME))
          .orElse(jwt.getClaimAsString(StandardClaimNames.NAME));
      String lastname = Optional.ofNullable(jwt.getClaimAsString(StandardClaimNames.FAMILY_NAME))
          .orElse("");
      String username = Optional.ofNullable(jwt.getClaimAsString("preferred_username"))
          .orElse(email);

      userProvisioningService.upsertUser(
          jwt.getIssuer() == null ? "keycloak" : jwt.getIssuer().toString(),
          jwt.getClaimAsString(StandardClaimNames.SUB),
          UserRequest.builder()
              .email(email)
              .username(username)
              .firstname(firstname == null ? username : firstname)
              .lastname(lastname)
              .build()
      );
    }

    @Component
    static class KeycloakAuthoritiesConverter
        implements Converter<Jwt, List<SimpleGrantedAuthority>> {
      @Value("${keycloak.client-id}")
      private String clientId;

      @Override
      @SuppressWarnings({"unchecked"})
      public List<SimpleGrantedAuthority> convert(@NonNull Jwt jwt) {
        final var realmAccess = (Map<String, Object>) jwt.getClaims()
            .getOrDefault("resource_access", Map.of());
        final var client = (Map<String, Object>) realmAccess.getOrDefault(clientId, Map.of());
        final var roles = (List<String>) client
            .getOrDefault("roles", List.of());
        final List<String> prefixRoles = roles.stream().map(s -> "ROLE_" + s).toList();
        final String clientScope = (String) jwt.getClaims()
            .getOrDefault("scope", "");
        final List<String> prefixScope = Arrays.stream(clientScope.split(" "))
            .map(s -> "SCOPE_" + s).toList();
        List<String> authorities = new ArrayList<>();
        authorities.addAll(prefixRoles);
        authorities.addAll(prefixScope);
        return authorities.stream().map(SimpleGrantedAuthority::new).toList();
      }
    }
  }
}
