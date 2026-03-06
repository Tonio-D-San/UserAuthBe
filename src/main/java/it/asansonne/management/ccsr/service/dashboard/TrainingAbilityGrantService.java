package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.common.ccsr.service.DeleteService;
import it.asansonne.common.ccsr.service.GetService;
import it.asansonne.common.ccsr.service.PatchService;
import it.asansonne.common.ccsr.service.PostService;
import it.asansonne.management.model.TrainingAbilityGrant;

public interface TrainingAbilityGrantService extends
    GetService<TrainingAbilityGrant>, PatchService<TrainingAbilityGrant>,
    PostService<TrainingAbilityGrant>, DeleteService
{

}
