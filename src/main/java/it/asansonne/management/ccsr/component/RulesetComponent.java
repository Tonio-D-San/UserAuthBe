package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.DeleteComponent;
import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.RulesetRequest;
import it.asansonne.management.dto.response.RulesetResponse;
import it.asansonne.management.model.Ruleset;
import java.util.UUID;

public interface RulesetComponent extends
    GetComponent<RulesetResponse>,
    PatchComponent<RulesetRequest>,
    PostComponent<RulesetRequest, RulesetResponse>,
    DeleteComponent
{
  RulesetResponse findByCode(String code);

  Ruleset getModel(UUID uuid);
}
