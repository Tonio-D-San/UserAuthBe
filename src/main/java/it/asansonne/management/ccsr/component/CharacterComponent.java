package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.CharacterRequest;
import it.asansonne.management.dto.response.CharacterResponse;
import it.asansonne.management.enumeration.character.AbilityName;

public interface CharacterComponent extends
    GetComponent<CharacterResponse>,
    PatchComponent<CharacterRequest>,
    PostComponent<CharacterRequest, CharacterResponse>
{
  CharacterResponse findByAbility(AbilityName ability);
}
