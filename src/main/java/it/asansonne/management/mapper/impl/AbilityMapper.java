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
    return null;
  }

  @Override
  public AbilityResponse toDto(Ability model) {
    return null;
  }
}
