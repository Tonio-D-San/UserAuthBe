package it.asansonne.authhub.ccsr.component.impl;

import it.asansonne.authhub.ccsr.component.UserComponent;
import it.asansonne.authhub.ccsr.service.UserService;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.authhub.exception.custom.UnauthorizedException;
import it.asansonne.authhub.mapper.UserMapper;
import it.asansonne.authhub.model.User;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * The type User component.
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserComponentImpl implements UserComponent {
  private final UserService service;
  private final UserMapper mapper;

  @Override
  public UserResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(findUser(uuid));
  }

  @Override
  public UserResponse me(Principal principal) {
    if (principal instanceof JwtAuthenticationToken jwtAuth) {
      Jwt jwt = jwtAuth.getToken();
      log.info("Authentication: {}", principal);
      UUID uuid = UUID.fromString(principal.getName());
      return mapper.toDto(
          service.findByUuid(uuid).orElseGet(() ->
              service.create(
                  User.builder()
                      .uuid(uuid)
                      .provider("Form")
                      .email(jwt.getClaimAsString("email"))
                      .username(jwt.getClaimAsString("preferred_username"))
                      .name(jwt.getClaimAsString("given_name"))
                      .surname(jwt.getClaimAsString("family_name"))
                      .profileUrl(jwt.getClaimAsString("picture"))
                      .build()
              )
          )
      );
    }
    throw new UnauthorizedException("Jwt not found");
  }

  @Override
  public Page<UserResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<UserResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public UserResponse create(Principal principal, UserRequest userRequest) {
    return this.mapper.toDto(this.service.create(
        User.builder()
            .provider("Form")
            .providerId(UUID.randomUUID().toString())
            .email(userRequest.getEmail())
            .username(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
            .name(userRequest.getFirstname())
            .surname(userRequest.getLastname())
            .profileUrl(userRequest.getProfileUrl())
            .build()
    ));
  }

  @Override
  public void updateByUuid(UUID uuid, UserRequest request) {
    User user = findUser(uuid);
    user.setIsActive(request.getStatusRequest().getIsActive());
    this.service.update(user);
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.service.deleteByUuid(uuid);
  }

  public User findUser(UUID uuid) {
    return this.service.findByUuid(uuid)
        .orElseThrow(() -> new NotFoundException("person.not.found", uuid))
        ;
  }

}
