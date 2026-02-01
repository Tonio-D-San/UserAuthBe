package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.DeleteComponent;
import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.AlchemyPathRequest;
import it.asansonne.management.dto.response.AlchemyPathResponse;

public interface AlchemyPathComponent extends
    GetComponent<AlchemyPathRequest, AlchemyPathResponse>,
    PatchComponent<AlchemyPathRequest, AlchemyPathResponse>,
    PostComponent<AlchemyPathRequest, AlchemyPathResponse>,
    DeleteComponent
{
  AlchemyPathResponse findByName(String name);
}
