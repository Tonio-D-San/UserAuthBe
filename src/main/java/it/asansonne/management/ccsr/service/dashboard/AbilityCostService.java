package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.model.AbilityCost;

public interface AbilityCostService extends
    GetService<AbilityCost>, PatchService<AbilityCost>, PostService<AbilityCost>
{
}
