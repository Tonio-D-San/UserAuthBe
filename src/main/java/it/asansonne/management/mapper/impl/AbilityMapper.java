package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;
import it.asansonne.management.model.Ability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class AbilityMapper implements 
    RequestMapper<AbilityRequest, Ability>, ResponseMapper<Ability, AbilityResponse>
{

  @Override
  public Ability toModel(AbilityRequest dto) {
    return dto == null ? null : Ability.builder()
        .code(dto.getAbilityName())
        .name(dto.getAbilityName().getName())
        .descriptionKey(dto.getAbilityName().getDescription())
        .type(null /*Prendere AbilityType tramite il code di AbilityName*/)
        .notes(null /*Prendere note da db da ability_notes*/)
        .requirements(null /*Prendere note da db*/)
        .unlockables(null /*Prendere note da db*/)
        .requirementType(null /*Prendere note da db*/)
        .build();
  }

  @Override
  public AbilityResponse toDto(Ability model) {
    return model == null ? null :  AbilityResponse.builder()
        .code(model.getCode())
        .name(model.getName())
        .description(model.getDescriptionKey())
        .type(model.getType())
        .requirementType(model.getRequirementType())
        .build();
  }

}
