package it.asansonne.authhub.ccsr.controller.users;

import it.asansonne.authhub.dto.request.StatusRequest;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;

/**
 * The interface User controller v1.
 */
public interface UserControllerV1 extends
    GetController<UserRequest, UserResponse>,
    PostController<UserRequest, UserResponse>,
    PatchController<StatusRequest, UserResponse>
{

}

