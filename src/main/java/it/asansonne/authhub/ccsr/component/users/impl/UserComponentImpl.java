package it.asansonne.authhub.ccsr.component.users.impl;

import it.asansonne.authhub.ccsr.component.users.UserComponent;
import it.asansonne.authhub.ccsr.service.users.UserService;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.authhub.mapper.impl.UserMapper;
import it.asansonne.authhub.model.users.User;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * The type User component.
 */
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
  public Page<UserResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<UserResponse> findAllByField(Pageable pageable, UserRequest request) {
    return this.mapper.toDto(this.service.findAllByField(pageable /*,request*/), pageable);
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
            .password(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
            .name(userRequest.getFirstname())
            .surname(userRequest.getLastname())
            .profileImage(userRequest.getProfileImage())
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
    this.mapper.toDto(this.service.deleteByUuid(uuid));
  }

  public User findUser(UUID uuid) {
    return this.service.findByUuid(uuid)
        .orElseThrow(() -> new NotFoundException("person.not.found", uuid))
    ;
  }
}
