package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;
import it.asansonne.management.model.AbilityDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class AbilityMapper implements 
    RequestMapper<AbilityRequest, AbilityDefinition>, ResponseMapper<AbilityDefinition, AbilityResponse>
{

  @Override
  public AbilityDefinition toModel(AbilityRequest dto) {
    return dto == null ? null : AbilityDefinition.builder()
        .code(dto.getAbilityName())
        .name(dto.getAbilityName().getName())
        .descriptionKey(dto.getAbilityName().getDescription())
        .type(null /*Prendere AbilityType tramite il code di AbilityName*/)
        .notes(null /*Prendere note da db da ability_definition_notes*/)
        .requirements(null /*Prendere note da db*/)
        .unlockables(null /*Prendere note da db*/)
        .requirementType(null /*Prendere note da db*/)
        .build();
  }

  @Override
  public AbilityResponse toDto(AbilityDefinition model) {
    return model == null ? null :  AbilityResponse.builder()
        .code(model.getCode())
        .name(model.getName())
        .description(model.getDescriptionKey())
        .type(model.getType())
        .requirementType(model.getRequirementType())
        .build();
  }

}
