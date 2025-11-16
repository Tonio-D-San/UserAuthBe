package it.asansonne.management.ccsr.controller.dashboard;

import it.asansonne.management.ccsr.controller.GetController;
import it.asansonne.management.dto.requests.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.Player;

public interface PlayerController extends GetController<PlayerRequest, PlayerResponse> {
  Player findPlayerByAbility(AbilityName abilityName);

}
