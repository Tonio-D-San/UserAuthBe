package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import it.asansonne.management.enumeration.character.AbilityName;

public interface PlayerComponent extends
    GetComponent<PlayerRequest, PlayerResponse>,
    PatchComponent<PlayerRequest, PlayerResponse>,
    PostComponent<PlayerRequest, PlayerResponse>
{
  PlayerResponse findByAbility(AbilityName ability);
}
