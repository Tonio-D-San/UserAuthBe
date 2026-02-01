package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.AbilityCostRequest;
import it.asansonne.management.dto.response.AbilityCostResponse;

public interface AbilityCostComponent extends
    GetComponent<AbilityCostRequest, AbilityCostResponse>,
    PatchComponent<AbilityCostRequest, AbilityCostResponse>,
    PostComponent<AbilityCostRequest, AbilityCostResponse>
{
}
