package it.asansonne.management.ccsr.controller.dashboard;

import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;

public interface AbilityController extends
    GetController<AbilityRequest, AbilityResponse> ,
    PatchController<AbilityRequest, AbilityResponse>,
    PostController<AbilityRequest, AbilityResponse>
{

}
