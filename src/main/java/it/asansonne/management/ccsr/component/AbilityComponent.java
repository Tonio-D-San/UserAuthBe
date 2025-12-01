package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;
import it.asansonne.management.enumeration.character.AbilityName;

public interface AbilityComponent extends
    GetComponent<AbilityRequest, AbilityResponse>,
    PatchComponent<AbilityRequest, AbilityResponse>,
    PostComponent<AbilityRequest, AbilityResponse>
{
  AbilityResponse findByAbility(AbilityName ability);
}
