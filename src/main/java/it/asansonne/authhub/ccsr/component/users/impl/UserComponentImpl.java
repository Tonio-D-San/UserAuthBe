package it.asansonne.authhub.ccsr.component.users.impl;

import it.asansonne.authhub.ccsr.component.users.UserComponent;
import it.asansonne.authhub.ccsr.service.users.UserService;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.authhub.mapper.impl.UserMapper;
import it.asansonne.authhub.model.User;
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
  public UserResponse findByUuid(UUID userUuid) {
    return mapper.toDto(findUser(userUuid));
  }

  @Override
  public Page<UserResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<UserResponse> findAllByField(Pageable pageable, UserRequest request) {
    return mapper.toDto(service.findAllByField(pageable /*,request*/), pageable);
  }

  @Override
  public UserResponse findLastAdded() {
    return mapper.toDto(
        service.findLastAdded().orElseThrow(() -> new NotFoundException("person.not.found"))
    );
  }

  @Override
  public Page<UserResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public UserResponse create(Principal principal, UserRequest userRequest) {
    return mapper.toDto(this.service.create(
        User.builder()
            .uuid(UUID.randomUUID())
            .provider("Form")
            .providerId(UUID.randomUUID().toString())
            .email(userRequest.getEmail())
            .password(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
            .name(userRequest.getFirstname())
            .surname(userRequest.getLastname())
            .isActive(true)
            .profileImage(userRequest.getProfileImage() == null ? null : userRequest.getProfileImage())
            .build()
    ));
  }

  @Override
  public void updateByUuid(UUID userUuid, UserRequest request) {
    User user = findUser(userUuid);
    user.setIsActive(request.getStatusRequest().getIsActive());
    this.service.update(user);
  }

  public User findUser(UUID userUuid) {
    return this.service.findByUuid(userUuid)
        .orElseThrow(() -> new NotFoundException("person.not.found", userUuid))
    ;
  }
}
