package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.DeleteComponent;
import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.RulesetRequest;
import it.asansonne.management.dto.response.RulesetResponse;

public interface RulesetComponent extends
    GetComponent<RulesetRequest, RulesetResponse>,
    PatchComponent<RulesetRequest, RulesetResponse>,
    PostComponent<RulesetRequest, RulesetResponse>,
    DeleteComponent
{
  RulesetResponse findByCode(String code);
}
