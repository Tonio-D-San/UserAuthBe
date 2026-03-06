package it.asansonne.management.ccsr.controller.dashboard;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.common.ccsr.controller.GetController;
import it.asansonne.common.ccsr.controller.PatchController;
import it.asansonne.common.ccsr.controller.PostController;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;

@Tag(name = "AbilityController" + AUTH_HUB_API_VERSION)
public interface AbilityController extends
    GetController<AbilityResponse> ,
    PatchController<AbilityRequest>,
    PostController<AbilityRequest, AbilityResponse>
{

}
