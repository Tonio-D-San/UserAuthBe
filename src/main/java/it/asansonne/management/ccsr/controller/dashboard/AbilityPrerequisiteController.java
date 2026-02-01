package it.asansonne.management.ccsr.controller.dashboard;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.management.dto.request.AbilityPrerequisiteRequest;
import it.asansonne.management.dto.response.AbilityPrerequisiteResponse;

@Tag(name = "AbilityPrerequisiteController" + AUTH_HUB_API_VERSION)
public interface AbilityPrerequisiteController extends
    GetController<AbilityPrerequisiteRequest, AbilityPrerequisiteResponse> ,
    PatchController<AbilityPrerequisiteRequest, AbilityPrerequisiteResponse>,
    PostController<AbilityPrerequisiteRequest, AbilityPrerequisiteResponse>
{

}
