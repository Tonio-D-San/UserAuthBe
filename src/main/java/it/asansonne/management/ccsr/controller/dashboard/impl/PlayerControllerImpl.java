package it.asansonne.management.ccsr.controller.dashboard.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.management.ccsr.component.PlayerComponent;
import it.asansonne.management.ccsr.controller.dashboard.PlayerController;
import it.asansonne.management.dto.requests.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.Player;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/players")
@AllArgsConstructor
public class PlayerControllerImpl implements PlayerController {

  private final PlayerComponent component;

  @Override
  public PlayerResponse findByUuid(UUID uuid) {
    return null;
  }

  @Override
  public Page<PlayerResponse> findActive(Integer page, Integer size, String direction,
                                         Boolean isActive) {
    return null;
  }

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public Page<PlayerResponse> findAll(
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "5") Integer size,
      @RequestParam(defaultValue = "asc") String direction,
      Locale locale
  ) {
    return component.findAll(page, size, direction, locale);
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
  public Player findPlayerByAbility(AbilityName abilityName) {
    return null;
  }
}
