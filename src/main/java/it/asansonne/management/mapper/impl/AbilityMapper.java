package it.asansonne.management.mapper.impl;

import it.asansonne.common.mapper.RequestMapper;
import it.asansonne.common.mapper.ResponseMapper;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;
import it.asansonne.management.model.Ability;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AbilityMapper implements
    RequestMapper<AbilityRequest, Ability>, ResponseMapper<Ability, AbilityResponse>
{

  private final RulesetMapper rulesetMapper;
  private final AbilityCostMapper abilityCostMapper;
  private final AbilityPrerequisiteMapper abilityPrerequisiteMapper;

  @Override
  public Ability toModel(AbilityRequest dto) {
    Ability model = Ability.builder()
        .code(dto.getCode())
        .name(dto.getName())
        .description(dto.getDescription())
        .isRepeatable(dto.getRepeatable())
        .maxRank(dto.getMaxRank())
        .build();
    log.info("Ability mapped from request: {}", model);
    return model;
  }

  @Override
  public AbilityResponse toDto(Ability model) {
    AbilityResponse response = AbilityResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .ruleset(rulesetMapper.toDto(model.getRuleset()))
        .code(model.getCode())
        .name(model.getName())
        .description(model.getDescription())
        .costResponseList(abilityCostMapper.toDto(model.getCosts()))
        .prerequisiteResponseList(abilityPrerequisiteMapper.toDto(model.getPrerequisites()))
        .build();
    log.info("AbilityResponse mapped from response: {}", response);
    return response;
  }
}
