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
        "Form",
        UUID.randomUUID().toString(),
        userRequest.getEmail(),
        userRequest.getFirstname(),
        userRequest.getLastname(),
        userRequest.getProfileImage() == null ? null : userRequest.getProfileImage()
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
