package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.common.ccsr.service.DeleteService;
import it.asansonne.common.ccsr.service.GetService;
import it.asansonne.common.ccsr.service.PatchService;
import it.asansonne.common.ccsr.service.PostService;
import it.asansonne.management.enumeration.Status;
import it.asansonne.management.model.Ruleset;
import java.util.Optional;
import java.util.UUID;

public interface RulesetService extends
    GetService<Ruleset>, PatchService<Ruleset>, PostService<Ruleset>, DeleteService
{
  Optional<Ruleset> findByCode(String code);

  void status(UUID uuid, Status status);
}
