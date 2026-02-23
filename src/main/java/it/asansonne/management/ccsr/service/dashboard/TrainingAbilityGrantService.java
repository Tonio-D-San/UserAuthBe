package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.DeleteService;
import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.model.TrainingAbilityGrant;

public interface TrainingAbilityGrantService extends
    GetService<TrainingAbilityGrant>, PatchService<TrainingAbilityGrant>,
    PostService<TrainingAbilityGrant>, DeleteService
{

}
