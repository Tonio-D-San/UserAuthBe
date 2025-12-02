package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.Player;
import java.util.Optional;

public interface PlayerService extends
    GetService<Player>, PatchService<Player>, PostService<Player>
{
  Optional<Player> findByAbility(AbilityName ability);
}
