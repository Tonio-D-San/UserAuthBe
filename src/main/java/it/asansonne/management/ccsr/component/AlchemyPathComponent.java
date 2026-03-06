package it.asansonne.management.ccsr.component;

import it.asansonne.common.ccsr.component.DeleteComponent;
import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.AlchemyPathRequest;
import it.asansonne.management.dto.response.AlchemyPathResponse;

public interface AlchemyPathComponent extends
    GetComponent<AlchemyPathResponse>,
    PatchComponent<AlchemyPathRequest>,
    PostComponent<AlchemyPathRequest, AlchemyPathResponse>,
    DeleteComponent
{
  AlchemyPathResponse findByName(String name);
}
