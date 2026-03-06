package it.asansonne.management.mapper.impl;

import it.asansonne.common.mapper.RequestMapper;
import it.asansonne.common.mapper.ResponseMapper;
import it.asansonne.management.dto.request.AlchemyPathRequest;
import it.asansonne.management.dto.response.AlchemyPathResponse;
import it.asansonne.management.model.AlchemyPath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AlchemyPathMapper implements
    RequestMapper<AlchemyPathRequest, AlchemyPath>, ResponseMapper<AlchemyPath, AlchemyPathResponse> {

  private final RulesetMapper rulesetMapper;

  @Override
  public AlchemyPath toModel(AlchemyPathRequest dto) {
    AlchemyPath model = AlchemyPath.builder()
//        .rulesetId(/*TODO da mettere nel component*/)
        .code(dto.getCode())
        .name(dto.getName())
        .description(dto.getDescription())
        .build();
    log.info("AlchemyPath mapped from request: {}", model);
    return model;
  }

  @Override
  public AlchemyPathResponse toDto(AlchemyPath model) {
    AlchemyPathResponse response = AlchemyPathResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .ruleset(rulesetMapper.toDto(model.getRuleset()))
        .code(model.getCode())
        .name(model.getName())
        .description(model.getDescription())
        .build();
    log.info("AlchemyPathResponse mapped from response: {}", response);
    return response;
  }

}
