package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.MixtureRequest;
import it.asansonne.management.dto.response.MixtureResponse;
import it.asansonne.management.model.Mixture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MixtureMapper implements
    RequestMapper<MixtureRequest, Mixture>, ResponseMapper<Mixture, MixtureResponse> {

  private final CharacterMapper characterMapper;
  private final RulesetMapper rulesetMapper;

  @Override
  public Mixture toModel(MixtureRequest dto) {
//    Mixture model = Mixture.builder()
//        .name(dto.getName())
//        .maxim(dto.getMaxim())
//        .build();
//    log.info("Mixture mapped from request: {}", model);
//    return model;
    return null;
  }

  @Override
  public MixtureResponse toDto(Mixture model) {
//    MixtureResponse response = MixtureResponse.builder()
//        .uuid(model.getUuid())
//        .updatedAt(model.getUpdatedAt())
//        .ruleset(rulesetMapper.toDto(model.getRuleset()))
//        .name(model.getName())
////        .description(model.getDescription())
//        .maxim(model.getMaxim())
//        .characters(characterMapper.toDto(model.getCharacters()))
//        .build();
//    log.info("MixtureResponse mapped from response: {}", response);
//    return response;
    return null;
  }

}
