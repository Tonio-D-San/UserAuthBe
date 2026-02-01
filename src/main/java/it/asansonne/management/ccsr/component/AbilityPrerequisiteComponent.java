package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.AbilityPrerequisiteRequest;
import it.asansonne.management.dto.response.AbilityPrerequisiteResponse;

public interface AbilityPrerequisiteComponent extends
    GetComponent<AbilityPrerequisiteRequest, AbilityPrerequisiteResponse>,
    PatchComponent<AbilityPrerequisiteRequest, AbilityPrerequisiteResponse>,
    PostComponent<AbilityPrerequisiteRequest, AbilityPrerequisiteResponse>
{
}
