package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.DeleteComponent;
import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.TrainingRequest;
import it.asansonne.management.dto.response.TrainingResponse;

public interface TrainingComponent extends
    GetComponent<TrainingRequest, TrainingResponse>,
    PatchComponent<TrainingRequest, TrainingResponse>,
    PostComponent<TrainingRequest, TrainingResponse>,
    DeleteComponent
{
  TrainingResponse findByName(String name);
}
