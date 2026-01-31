package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.DeleteComponent;
import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.RealmRequest;
import it.asansonne.management.dto.response.RealmResponse;

public interface RealmComponent extends
    GetComponent<RealmRequest, RealmResponse>,
    PatchComponent<RealmRequest, RealmResponse>,
    PostComponent<RealmRequest, RealmResponse>,
    DeleteComponent
{
  RealmResponse findByName(String name);
}
