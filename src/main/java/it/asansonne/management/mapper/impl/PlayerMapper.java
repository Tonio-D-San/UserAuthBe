package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.authhub.mapper.impl.UserMapper;
import it.asansonne.management.dto.request.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import it.asansonne.management.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class PlayerMapper implements
    RequestMapper<PlayerRequest, Player>, ResponseMapper<Player, PlayerResponse>
{

  private final UserMapper userMapper;
  private final AbilityMapper abilityMapper;
  private final RealmMapper realmMapper;

  @Override
  public Player toModel(PlayerRequest dto) {
    return dto == null ? null : Player.builder()
        .pgName(dto.getName())
        .background(dto.getBackground())
        .training(dto.getTraining())
        .abilities(abilityMapper.toModel(dto.getAbilities()))
        .build();
  }

  @Override
  public PlayerResponse toDto(Player model) {
    return model == null ? null : PlayerResponse.builder()
        .uuid(model.getUuid())
        .name(model.getPgName())
        .realm(realmMapper.toDto(model.getRealm()))
        .user(userMapper.toDto(model.getUser()))
        .build();
  }

}
