package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.RealmRequest;
import it.asansonne.management.dto.response.RealmResponse;
import it.asansonne.management.model.Realm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class RealmMapper implements
    RequestMapper<RealmRequest, Realm>, ResponseMapper<Realm, RealmResponse>
{

  @Override
  public Realm toModel(RealmRequest dto) {
    return dto == null ? null : Realm.builder()
        .realmName(dto.getRealmName())
        .build();
  }

  @Override
  public RealmResponse toDto(Realm model) {
    return model == null ? null : RealmResponse.builder()
        .uuid(model.getUuid())
        .name(model.getRealmName().getName())
        .build();
  }

}
