package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.DeleteComponent;
import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.RealmRequest;
import it.asansonne.management.dto.response.RealmResponse;

public interface RealmComponent extends
    GetComponent<RealmResponse>,
    PatchComponent<RealmRequest>,
    PostComponent<RealmRequest, RealmResponse>,
    DeleteComponent
{
  RealmResponse findByName(String name);
}
