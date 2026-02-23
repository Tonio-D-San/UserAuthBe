package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.DeleteService;
import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.model.AbilityPrerequisite;

public interface AbilityPrerequisiteService extends
    GetService<AbilityPrerequisite>, PatchService<AbilityPrerequisite>,
    PostService<AbilityPrerequisite>, DeleteService
{
}
