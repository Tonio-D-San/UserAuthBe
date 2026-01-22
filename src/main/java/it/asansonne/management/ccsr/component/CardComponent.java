package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.CardRequest;
import it.asansonne.management.dto.response.CardResponse;

public interface CardComponent extends
    GetComponent<CardRequest, CardResponse>,
    PatchComponent<CardRequest, CardResponse>,
    PostComponent<CardRequest, CardResponse>
{

}
