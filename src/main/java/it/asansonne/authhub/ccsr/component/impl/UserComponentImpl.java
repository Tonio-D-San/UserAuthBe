package it.asansonne.authhub.ccsr.component.impl;

import it.asansonne.authhub.ccsr.component.UserComponent;
import it.asansonne.authhub.ccsr.service.UserService;
import it.asansonne.authhub.dto.request.StatusRequest;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.authhub.mapper.ResponseModelMapper;
import it.asansonne.authhub.model.jpa.User;
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
  private final ResponseModelMapper<User, UserResponse> userResponseModelMapper;

  @Override
  public UserResponse findUserByUuid(UUID userUuid) {
    return userResponseModelMapper.toDto(findUser(userUuid));
  }

  @Override
  public Page<UserResponse> findAllUsers(Pageable pageable) {
    return userResponseModelMapper.toDto(userService.findAllUsers(pageable), pageable);
  }

  @Override
  public Page<UserResponse> findActiveUsers(Boolean isActive, Pageable pageable ) {
    return userResponseModelMapper.toDto(userService.findActiveUsers(isActive, pageable), pageable);
  }

  @Override
  public UserResponse createPerson(UserRequest userRequest) {

    return userResponseModelMapper.toDto(userService.createUser(
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
  public void updateStatusUserByUuid(UUID userUuid, StatusRequest status) {
    User user = findUser(userUuid);
    user.setIsActive(status.getIsActive());
    userService.updateUser(user);
  }

  private User findUser(UUID userUuid) {
    return userService.findUserByUuid(userUuid)
        .orElseThrow(() -> new NotFoundException("person.not.found"));
  }

}
