package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.common.ccsr.service.DeleteService;
import it.asansonne.common.ccsr.service.GetService;
import it.asansonne.common.ccsr.service.PatchService;
import it.asansonne.common.ccsr.service.PostService;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.Character;
import java.util.Optional;

public interface CharacterService extends
    GetService<Character>, PatchService<Character>, PostService<Character>, DeleteService
{
  Optional<Character> findByAbility(AbilityName ability);
}
