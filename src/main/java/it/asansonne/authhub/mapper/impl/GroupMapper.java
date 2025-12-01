package it.asansonne.authhub.mapper.impl;

import it.asansonne.authhub.dto.request.GroupRequest;
import it.asansonne.authhub.dto.response.GroupResponse;
import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.authhub.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class GroupMapper implements RequestMapper<GroupRequest, Group>,
    ResponseMapper<Group, GroupResponse> {

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
