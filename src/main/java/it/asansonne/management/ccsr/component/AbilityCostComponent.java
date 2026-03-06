package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.AbilityCostRequest;
import it.asansonne.management.dto.response.AbilityCostResponse;

public interface AbilityCostComponent extends
    GetComponent<AbilityCostResponse>,
    PatchComponent<AbilityCostRequest>,
    PostComponent<AbilityCostRequest, AbilityCostResponse>
{
}
