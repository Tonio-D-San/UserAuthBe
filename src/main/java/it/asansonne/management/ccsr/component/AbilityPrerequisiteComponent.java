package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.AbilityPrerequisiteRequest;
import it.asansonne.management.dto.response.AbilityPrerequisiteResponse;

public interface AbilityPrerequisiteComponent extends
    GetComponent<AbilityPrerequisiteResponse>,
    PatchComponent<AbilityPrerequisiteRequest>,
    PostComponent<AbilityPrerequisiteRequest, AbilityPrerequisiteResponse>
{
}
