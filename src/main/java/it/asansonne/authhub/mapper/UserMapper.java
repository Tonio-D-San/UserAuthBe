package it.asansonne.authhub.mapper;

import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.model.User;
import it.asansonne.common.mapper.RequestMapper;
import it.asansonne.common.mapper.ResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class UserMapper implements RequestMapper<UserRequest, User>,
    ResponseMapper<User, UserResponse> {

  private final GroupMapper groupMapper;

  @Override
  public User toModel(UserRequest dto) {
    return dto == null ? null : User.builder()
        .biography(dto.getBiography())
        .build();
  }

  @Override
  public UserResponse toDto(User model) {
    if (model == null) {
      return null;
    }
    return UserResponse.builder()
        .username(model.getUsername())
        .uuid(model.getUuid())
        .provider(model.getProvider())
        .email(model.getEmail())
        .firstName(model.getName())
        .lastName(model.getSurname())
        .biography(model.getBiography())
        .enabled(model.getIsActive())
        .groups(model.getGroups() != null ? this.groupMapper.toDto(model.getGroups()) : null)
        .profileUrl(model.getProfileUrl() != null ? model.getProfileUrl() : null)
        .build();
  }

}
