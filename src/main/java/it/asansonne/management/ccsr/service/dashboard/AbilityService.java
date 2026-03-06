package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.common.ccsr.service.DeleteService;
import it.asansonne.common.ccsr.service.GetService;
import it.asansonne.common.ccsr.service.PatchService;
import it.asansonne.common.ccsr.service.PostService;
import it.asansonne.management.model.Ability;

public interface AbilityService extends
    GetService<Ability>, PatchService<Ability>, PostService<Ability>, DeleteService
{
}
