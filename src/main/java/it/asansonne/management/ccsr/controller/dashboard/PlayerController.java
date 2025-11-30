package it.asansonne.management.ccsr.controller.dashboard;

import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.management.dto.request.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.Player;

public interface PlayerController extends
    GetController<PlayerRequest, PlayerResponse> ,
    PostController<PlayerRequest, PlayerResponse>,
    PatchController<PlayerRequest, PlayerResponse>
{
  Player findPlayerByAbility(AbilityName abilityName);

}
