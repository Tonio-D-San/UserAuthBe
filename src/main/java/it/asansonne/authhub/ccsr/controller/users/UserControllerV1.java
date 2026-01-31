package it.asansonne.authhub.ccsr.controller.users;

import it.asansonne.authhub.ccsr.controller.DeleteController;
import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;

/**
 * The interface User controller v1.
 */
public interface UserControllerV1 extends
    GetController<UserRequest, UserResponse>,
    PostController<UserRequest, UserResponse>,
    PatchController<UserRequest, UserResponse>,
    DeleteController
{

}

