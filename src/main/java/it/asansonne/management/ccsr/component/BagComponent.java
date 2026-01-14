package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.BagRequest;
import it.asansonne.management.dto.response.BagResponse;

public interface BagComponent extends
    GetComponent<BagRequest, BagResponse>,
    PatchComponent<BagRequest, BagResponse>,
    PostComponent<BagRequest, BagResponse>
{

}
