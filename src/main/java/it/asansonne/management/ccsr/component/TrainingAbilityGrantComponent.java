package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.DeleteComponent;
import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.TrainingAbilityGrantRequest;
import it.asansonne.management.dto.response.TrainingAbilityGrantResponse;

public interface TrainingAbilityGrantComponent extends
    GetComponent<TrainingAbilityGrantResponse>,
    PatchComponent<TrainingAbilityGrantRequest>,
    PostComponent<TrainingAbilityGrantRequest, TrainingAbilityGrantResponse>,
    DeleteComponent
{

}
