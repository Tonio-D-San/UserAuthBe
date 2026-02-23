package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.DeleteService;
import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.Character;
import java.util.Optional;

public interface CharacterService extends
    GetService<Character>, PatchService<Character>, PostService<Character>, DeleteService
{
  Optional<Character> findByAbility(AbilityName ability);
}
