package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.RealmRequest;
import it.asansonne.management.dto.response.RealmResponse;
import it.asansonne.management.model.Realm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RealmMapper implements
    RequestMapper<RealmRequest, Realm>, ResponseMapper<Realm, RealmResponse> {

  private final CharacterMapper characterMapper;

  @Override
  public Realm toModel(RealmRequest dto) {
    Realm model = Realm.builder()
        .name(dto.getName())
        .maxim(dto.getMaxim())
        .build();
    log.info("Realm mapped from request: {}", model);
    return model;
  }

  @Override
  public RealmResponse toDto(Realm model) {
    RealmResponse response = RealmResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .name(model.getName())
//        .description(model.getDescription())
        .maxim(model.getMaxim())
        .characters(characterMapper.toDto(model.getCharacters()))
        .build();
    log.info("RealmResponse mapped from response: {}", response);
    return response;
  }
}
