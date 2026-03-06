package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.common.ccsr.service.DeleteService;
import it.asansonne.common.ccsr.service.GetService;
import it.asansonne.common.ccsr.service.PatchService;
import it.asansonne.common.ccsr.service.PostService;
import it.asansonne.management.model.AbilityPrerequisite;

public interface AbilityPrerequisiteService extends
    GetService<AbilityPrerequisite>, PatchService<AbilityPrerequisite>,
    PostService<AbilityPrerequisite>, DeleteService
{
}
