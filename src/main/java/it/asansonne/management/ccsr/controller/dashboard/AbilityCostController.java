package it.asansonne.management.ccsr.controller.dashboard;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.common.ccsr.controller.GetController;
import it.asansonne.common.ccsr.controller.PatchController;
import it.asansonne.common.ccsr.controller.PostController;
import it.asansonne.management.dto.request.AbilityCostRequest;
import it.asansonne.management.dto.response.AbilityCostResponse;

@Tag(name = "AbilityCostController" + AUTH_HUB_API_VERSION)
public interface AbilityCostController extends
    GetController<AbilityCostResponse> ,
    PatchController<AbilityCostRequest>,
    PostController<AbilityCostRequest, AbilityCostResponse>
{

}
