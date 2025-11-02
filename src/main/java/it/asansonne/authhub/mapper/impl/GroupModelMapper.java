package it.asansonne.authhub.mapper.impl;

import it.asansonne.authhub.dto.request.GroupRequest;
import it.asansonne.authhub.dto.response.GroupResponse;
import it.asansonne.authhub.mapper.RequestModelMapper;
import it.asansonne.authhub.mapper.ResponseModelMapper;
import it.asansonne.authhub.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class GroupModelMapper implements RequestModelMapper<GroupRequest, Group>,
    ResponseModelMapper<Group, GroupResponse> {

  @Override
  public Group toModel(GroupRequest dto) {
    if (dto == null) {
      return null;
    }
    return Group.builder()
        .uuid(dto.getUuid())
        .build();
  }

  @Override
  public GroupResponse toDto(Group model) {
    if (model == null) {
      return null;
    }
    return GroupResponse.builder()
        .uuid(model.getUuid())
        .name(model.getName().getName())
        .path(model.getPath())
        .build();
  }

}
