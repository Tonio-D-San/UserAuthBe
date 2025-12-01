package it.asansonne.authhub.ccsr.component.users.impl;

import it.asansonne.authhub.ccsr.component.users.UserComponent;
import it.asansonne.authhub.ccsr.service.users.UserService;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.authhub.mapper.ResponseMapper;
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
  private final UserService userService;
  private final ResponseMapper<User, UserResponse> userResponseMapper;

  @Override
  public UserResponse findByUuid(UUID userUuid) {
    return userResponseMapper.toDto(findUser(userUuid));
  }

  @Override
  public Page<UserResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return userResponseMapper.toDto(userService.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<UserResponse> findAllByField(Integer page, Integer size, String direction,
                                           UserRequest request) {
    return null;
  }

  @Override
  public UserResponse findLastAdded() {
    return null;
  }

  @Override
  public Page<UserResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return userResponseMapper.toDto(userService.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public UserResponse create(Principal principal, UserRequest userRequest) {
    return userResponseMapper.toDto(userService.create(
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
    userService.update(user);
  }

  public User findUser(UUID userUuid) {
    return userService.findByUuid(userUuid)
        .orElseThrow(() -> new NotFoundException("person.not.found", userUuid))
    ;
  }
}
