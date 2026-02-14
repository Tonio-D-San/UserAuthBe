package it.asansonne.authhub.security.provider;

import static it.asansonne.authhub.enumeration.GroupName.ADMIN;

import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.model.users.User;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class CustomOauth2UserService implements OAuth2UserService<OidcUserRequest, OidcUser>{

  private final UserProvisioningService userProvisioningService;

  @Bean
  public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
    return userRequest -> {
      OidcUser oidcUser = new OidcUserService().loadUser(userRequest);
      Set<GrantedAuthority> mappedAuthorities = new HashSet<>(oidcUser.getAuthorities());

      if ("toniosansa@gmail.com".equalsIgnoreCase(oidcUser.getEmail())) {
        mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
      }
      mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

      return new DefaultOidcUser(
          mappedAuthorities,
          oidcUser.getIdToken(),
          oidcUser.getUserInfo()
      );
    };
  }

  @Override
  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
    OidcUser oidcUser = new OidcUserService().loadUser(userRequest);

    String provider = userRequest.getClientRegistration().getRegistrationId();
    String providerId = oidcUser.getSubject();
    String email = oidcUser.getEmail();
    String name = oidcUser.getGivenName();
    String surname = oidcUser.getFamilyName();
    byte[] pictureBytes = oidcUser.getPicture() == null
        ? null
        : new RestTemplate().getForObject(oidcUser.getPicture(), byte[].class);

    Set<GrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority(
        getUser(provider, email, name, surname, providerId, pictureBytes)
            .getGroups()
            .stream()
            .anyMatch(group ->
                ADMIN.getName().equalsIgnoreCase(group.getName().getName())
            ) ? "ROLE_ADMIN" : "ROLE_USER"
    ));

    return new DefaultOidcUser(
        authorities,
        oidcUser.getIdToken(),
        oidcUser.getUserInfo()
    );
  }

  private User getUser(String provider, String email, String name, String surname,
                       String providerId, byte[] pictureBytes) {
    log.info("OIDC login for provider={} email={} name={} surname={}", provider, email, name,
        surname);
    return userProvisioningService.upsertUser(
        provider,
        providerId,
        UserRequest.builder()
            .email(email)
            .firstname(name)
            .lastname(surname)
            .username(email)
            .profileImage(pictureBytes)
            .build()
    );
  }

}
