package it.asansonne.management.ccsr.controller.dashboard;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.authhub.ccsr.controller.DeleteController;
import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.management.dto.request.TrainingAbilityGrantRequest;
import it.asansonne.management.dto.response.TrainingAbilityGrantResponse;

@Tag(name = "Training Ability Grant Controller" + AUTH_HUB_API_VERSION)
public interface TrainingAbilityGrantController extends
    GetController<TrainingAbilityGrantRequest, TrainingAbilityGrantResponse> ,
    PatchController<TrainingAbilityGrantRequest, TrainingAbilityGrantResponse>,
    PostController<TrainingAbilityGrantRequest, TrainingAbilityGrantResponse>,
    DeleteController
{

}
