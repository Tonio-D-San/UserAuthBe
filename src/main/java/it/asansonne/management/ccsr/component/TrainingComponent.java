package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.DeleteComponent;
import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.TrainingRequest;
import it.asansonne.management.dto.response.TrainingResponse;

public interface TrainingComponent extends
    GetComponent<TrainingResponse>,
    PatchComponent<TrainingRequest>,
    PostComponent<TrainingRequest, TrainingResponse>,
    DeleteComponent
{
  TrainingResponse findByName(String name);
}
