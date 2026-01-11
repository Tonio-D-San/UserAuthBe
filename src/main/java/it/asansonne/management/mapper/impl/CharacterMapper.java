package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.authhub.mapper.impl.UserMapper;
import it.asansonne.management.dto.request.CharacterRequest;
import it.asansonne.management.dto.response.CharacterResponse;
import it.asansonne.management.model.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class CharacterMapper implements
    RequestMapper<CharacterRequest, Character>, ResponseMapper<Character, CharacterResponse>
{

  private final UserMapper userMapper;
  private final AbilityMapper abilityMapper;
  private final RealmMapper realmMapper;

  @Override
  public Character toModel(CharacterRequest dto) {
    return dto == null ? null : Character.builder()
        .pgName(dto.getName())
        .background(dto.getBackground())
        .training(dto.getTraining())
        .abilities(abilityMapper.toModel(dto.getAbilities()))
        .build();
  }

  @Override
  public CharacterResponse toDto(Character model) {
    return model == null ? null : CharacterResponse.builder()
        .uuid(model.getUuid())
        .name(model.getPgName())
        .realm(realmMapper.toDto(model.getRealm()))
        .user(userMapper.toDto(model.getUser()))
        .build();
  }

}
