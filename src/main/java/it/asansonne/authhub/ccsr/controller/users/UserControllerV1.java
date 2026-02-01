package it.asansonne.authhub.ccsr.controller.users;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.authhub.ccsr.controller.DeleteController;
import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;

/**
 * The interface User controller v1.
 */
@Tag(name = "UserController" + AUTH_HUB_API_VERSION)
public interface UserControllerV1 extends
    GetController<UserRequest, UserResponse>,
    PostController<UserRequest, UserResponse>,
    PatchController<UserRequest, UserResponse>,
    DeleteController
{

}

