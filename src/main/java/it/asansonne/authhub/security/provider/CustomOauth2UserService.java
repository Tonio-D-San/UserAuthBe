package it.asansonne.authhub.security.provider;

import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomOauth2UserService implements OAuth2UserService<OidcUserRequest, OidcUser> {

  @Override
  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
    OidcUser oidcUser = new OidcUserService().loadUser(userRequest);
    Set<GrantedAuthority> mappedAuthorities = new HashSet<>(oidcUser.getAuthorities());
    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    return new DefaultOidcUser(
        mappedAuthorities,
        oidcUser.getIdToken(),
        oidcUser.getUserInfo()
    );
  }
}
