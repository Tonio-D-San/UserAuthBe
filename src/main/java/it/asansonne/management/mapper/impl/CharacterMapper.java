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

  @Override
  public Character toModel(CharacterRequest dto) {
    return null;
  }

  @Override
  public CharacterResponse toDto(Character model) {
    return null;
  }
}
