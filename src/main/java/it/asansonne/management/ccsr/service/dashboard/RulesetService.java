package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.DeleteService;
import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.enumeration.Status;
import it.asansonne.management.model.Ruleset;
import java.util.Optional;
import java.util.UUID;

public interface RulesetService extends
    GetService<Ruleset>, PatchService<Ruleset>, PostService<Ruleset>, DeleteService<Ruleset>
{
  Optional<Ruleset> findByCode(String code);

  void status(UUID uuid, Status status);
}
