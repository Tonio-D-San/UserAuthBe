package it.asansonne.authhub.security;

import it.asansonne.authhub.exception.handler.AuthorizationAuthenticationHandler;
import it.asansonne.authhub.security.provider.CustomOauth2UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

/**
 * The type Web security configuration.
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfiguration {

  private final AuthorizationAuthenticationHandler handler;
  private final CustomOauth2UserService customOAuth2UserService;
  private final ManageToken manageToken;
  private static final String LOGIN_PROCESSING_URL = "http://localhost:5173/login";

  @Bean
  protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    log.info("Configuring security filter chain");
    return http
        .addFilterBefore(manageToken, UsernamePasswordAuthenticationFilter.class)
        .cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(requests -> requests
            .requestMatchers(new AntPathRequestMatcher("/api/v*/**")).authenticated()
            .anyRequest().permitAll()
//        ).formLogin(
//            form -> form
//                .loginPage(LOGIN_PROCESSING_URL)
//                .loginProcessingUrl(LOGIN_PROCESSING_URL)
//                .defaultSuccessUrl("/api/v1/swagger-ui/index.html", true)
//                .failureUrl(LOGIN_PROCESSING_URL + "?error=true")
//                .permitAll()
        ).oauth2Login(oauth -> oauth
            .loginPage(LOGIN_PROCESSING_URL)
            .userInfoEndpoint(userInfo -> userInfo
                .oidcUserService(customOAuth2UserService)
            ).defaultSuccessUrl("/api/v1/swagger-ui/index.html", true)
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
                res.sendRedirect(LOGIN_PROCESSING_URL)
            ).defaultAuthenticationEntryPointFor(handler, new AntPathRequestMatcher("/api/**"))
            .defaultAccessDeniedHandlerFor(handler, new AntPathRequestMatcher("/api/**"))
        ).build();
  }

}
