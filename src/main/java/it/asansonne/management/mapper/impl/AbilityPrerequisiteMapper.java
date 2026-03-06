package it.asansonne.management.mapper.impl;

import it.asansonne.common.mapper.RequestMapper;
import it.asansonne.common.mapper.ResponseMapper;
import it.asansonne.management.dto.request.AbilityPrerequisiteRequest;
import it.asansonne.management.dto.response.AbilityPrerequisiteResponse;
import it.asansonne.management.model.AbilityPrerequisite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AbilityPrerequisiteMapper implements
    RequestMapper<AbilityPrerequisiteRequest, AbilityPrerequisite>, ResponseMapper<AbilityPrerequisite, AbilityPrerequisiteResponse>
{

  @Override
  public AbilityPrerequisite toModel(AbilityPrerequisiteRequest dto) {
    AbilityPrerequisite model = AbilityPrerequisite.builder()
        .requiredRank(dto.getRequiredRank())
        .build();
    log.info("Ability Prerequisite mapped from request: {}", model);
    return model;
  }

  @Override
  public AbilityPrerequisiteResponse toDto(AbilityPrerequisite model) {
    AbilityPrerequisiteResponse response = AbilityPrerequisiteResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .requiredRank(model.getRequiredRank())
        .build();
    log.info("AbilityPrerequisiteResponse mapped from response: {}", response);
    return response;
  }
}
