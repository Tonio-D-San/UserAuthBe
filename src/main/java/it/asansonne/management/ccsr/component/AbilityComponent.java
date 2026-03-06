package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;

public interface AbilityComponent extends
    GetComponent<AbilityResponse>,
    PatchComponent<AbilityRequest>,
    PostComponent<AbilityRequest, AbilityResponse>
{
}
