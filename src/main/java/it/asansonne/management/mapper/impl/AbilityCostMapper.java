package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.AbilityCostRequest;
import it.asansonne.management.dto.response.AbilityCostResponse;
import it.asansonne.management.model.AbilityCost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AbilityCostMapper implements
    RequestMapper<AbilityCostRequest, AbilityCost>, ResponseMapper<AbilityCost, AbilityCostResponse>
{

  @Override
  public AbilityCost toModel(AbilityCostRequest dto) {
    AbilityCost model = AbilityCost.builder()
        .rank(dto.getRank())
        .cost(dto.getCost())
        .build();
    log.info("Realm mapped from request: {}", model);
    return model;
  }

  @Override
  public AbilityCostResponse toDto(AbilityCost model) {
    AbilityCostResponse response = AbilityCostResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .requiredRank(model.getRank())
        .build();
    log.info("RealmResponse mapped from response: {}", response);
    return response;
  }
}
