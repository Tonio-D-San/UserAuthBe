package it.asansonne.management.mapper.impl;

import static it.asansonne.management.enumeration.Status.DRAFT;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.RulesetRequest;
import it.asansonne.management.dto.response.RulesetResponse;
import it.asansonne.management.model.Ruleset;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RulesetMapper implements
    RequestMapper<RulesetRequest, Ruleset>, ResponseMapper<Ruleset, RulesetResponse> {

  @Override
  public Ruleset toModel(RulesetRequest dto) {
    Ruleset model = Ruleset.builder()
        .code(dto.getCode().toUpperCase())
        .name(dto.getName())
        .status(
            dto.getStatusRequest() == null
                ? DRAFT.toString()
                : dto.getStatusRequest().getStatus().toString()
        ).description(dto.getDescription())
        .initialPoints(dto.getInitialPoints())
        .requiredSpendPoints(dto.getRequiredSpendPoints())
        .maxPointsAtCreation(dto.getMaxPointsAtCreation())
        .build();
    log.info("Ruleset mapped from request: {}", model);
    return model;
  }

  @Override
  public RulesetResponse toDto(Ruleset model) {
    RulesetResponse response = RulesetResponse.builder()
        .uuid(model.getUuid())
        .code(model.getCode())
        .version(model.getVersion())
        .status(model.getStatus())
        .previousRulesetUuid(model.getPreviousRulesetUuid())
        .publishedAt(model.getPublishedAt())
        .name(model.getName())
        .description(model.getDescription())
        .initialPoints(model.getInitialPoints())
        .requiredSpendPoints(model.getRequiredSpendPoints())
        .maxPointsAtCreation(model.getMaxPointsAtCreation())
        .active(model.getIsActive())
        .updatedAt(model.getUpdatedAt())
        .build();
    log.info("RulesetResponse mapped from response: {}", response);
    return response;
  }
}
