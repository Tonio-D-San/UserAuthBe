package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.ccsr.component.users.UserComponent;
import it.asansonne.authhub.ccsr.service.users.UserService;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.authhub.model.User;
import it.asansonne.management.ccsr.component.PlayerComponent;
import it.asansonne.management.ccsr.service.dashboard.PlayerService;
import it.asansonne.management.dto.request.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import it.asansonne.management.mapper.impl.RealmMapper;
import it.asansonne.management.model.Player;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerComponentImpl implements PlayerComponent {
  private final UserComponent userComponent;
  private final RequestMapper<PlayerRequest, Player> playerRequestMapper;
  private final ResponseMapper<Player, PlayerResponse> playerResponseMapper;
  private final RequestMapper<UserRequest, User> userRequestMapper;
  private final ResponseMapper<User, UserResponse> userResponseMapper;
  private final PlayerService playerService;
  private final RealmMapper realmMapper;
  private final UserService userService;


  @Override
  public Page<PlayerResponse> findAll(Integer page, Integer size, String direction, Locale locale) {
    return null;
  }

  @Override
  public PlayerResponse findByUuid(UUID uuid) {
    return null;
  }

  @Override
  public Page<PlayerResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<PlayerResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return null;
  }

  @Override
  public Page<PlayerResponse> findAllByField(Integer page, Integer size, String direction,
                                             PlayerRequest request) {
    return null;
  }

  @Override
  public PlayerResponse findLastAdded() {
    return null;
  }

  @Override
  public void updateByUuid(UUID uuid, PlayerRequest request) {

  }

  @Override
  public PlayerResponse create(Principal principal, PlayerRequest request) {
    return playerResponseMapper.toDto(
        playerService.create(
            Player.builder()
                .uuid(UUID.randomUUID())
                .pgName(request.getName())
                .background(request.getBackground())
                .diaries(null) //TODO implement
                .training(request.getTraining())
                .realm(realmMapper.toModel(request.getRealm()))
                .user(fromPrincipal(principal))
                .build()
        )
    );
    /*
    Un player alla creazione deve avere:
      - nome
      - scegliere da dove viene (regno)
      - lista di abilità (ogni abilità è da 3 punti)
      - si hanno 16 PS (punti scheda)
      - si devono usare 15 punti obbligatori
      - i PG partono con 2 PV
      - scegliere Background (storia del personaggio)
      - allegare foto costume e attrezzature
      - foto a figura intera con calzature
      - scegliere la formazione (dà abilità gratis)
      - scegliere le abilità
     */
  }

  private User fromPrincipal(Principal principal) {
    return userComponent.findUser(
        UUID.fromString(principal.getName().split("[,\\[\\]\\s]+")[0])
    );
  }

}
