package it.asansonne.authhub.mapper.impl;

import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.mapper.RequestModelMapper;
import it.asansonne.authhub.mapper.ResponseModelMapper;
import it.asansonne.authhub.model.jpa.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class UserModelMapper implements RequestModelMapper<UserRequest, User>,
    ResponseModelMapper<User, UserResponse> {

  private final GroupModelMapper groupModelMapper;

  @Override
  public User toModel(UserRequest dto) {
    if (dto == null) {
      return null;
    }
    return User.builder()
        .biography(dto.getBiography())
        .build();
  }

  @Override
  public UserResponse toDto(User model) {
    if (model == null) {
      return null;
    }
    return UserResponse.builder()
        .uuid(model.getUuid())
        .provider(model.getProvider())
        .email(model.getEmail())
        .firstName(model.getName())
        .lastName(model.getSurname())
        .biography(model.getBiography())
        .enabled(model.getIsActive())
        .groups(model.getGroups() != null ? groupModelMapper.toDto(model.getGroups()) : null)
        .profileImage(model.getProfileImage())
        .build();
  }

}
