package it.asansonne.authhub.security;

import it.asansonne.authhub.exception.handler.AuthorizationAuthenticationHandler;
import it.asansonne.authhub.security.provider.CustomOauth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
  private static final String LOGIN_PROCESSING_URL = "/login";

  @Bean
  protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    log.info("Configuring security filter chain");
    return http
        .addFilterBefore(manageToken, UsernamePasswordAuthenticationFilter.class)
        .cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(requests -> requests
            // Proteggi solo le API
            .requestMatchers(
                new AntPathRequestMatcher("/api/v*/**")
            ).authenticated()
            .anyRequest()
            .permitAll()
        ).formLogin(
            form -> form
                .loginPage(LOGIN_PROCESSING_URL)
                .loginProcessingUrl(LOGIN_PROCESSING_URL)
                .defaultSuccessUrl("/api/v1/swagger-ui/index.html", true)
                .failureUrl(LOGIN_PROCESSING_URL + "?error=true")
                .permitAll()
        ).oauth2Login(oauth -> oauth
            .loginPage(LOGIN_PROCESSING_URL)
            .userInfoEndpoint(userInfo -> userInfo
                .oidcUserService(customOAuth2UserService)
            ).defaultSuccessUrl("/api/v1/swagger-ui/index.html", true)
            .permitAll()
        ).logout(logout -> logout
            .logoutSuccessUrl("/")
            .permitAll()
        ).sessionManagement(session -> {
              session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
              session.maximumSessions(1).maxSessionsPreventsLogin(false);
            }
        ).exceptionHandling(exceptionHandling -> exceptionHandling
            .defaultAuthenticationEntryPointFor(handler, new AntPathRequestMatcher("/api/**"))
            .defaultAccessDeniedHandlerFor(handler, new AntPathRequestMatcher("/api/**"))
        ).build();
  }

}
