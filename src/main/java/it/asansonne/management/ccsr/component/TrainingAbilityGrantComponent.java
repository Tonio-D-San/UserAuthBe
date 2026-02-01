package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.DeleteComponent;
import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.TrainingAbilityGrantRequest;
import it.asansonne.management.dto.response.TrainingAbilityGrantResponse;

public interface TrainingAbilityGrantComponent extends
    GetComponent<TrainingAbilityGrantRequest, TrainingAbilityGrantResponse>,
    PatchComponent<TrainingAbilityGrantRequest, TrainingAbilityGrantResponse>,
    PostComponent<TrainingAbilityGrantRequest, TrainingAbilityGrantResponse>,
    DeleteComponent
{

}
