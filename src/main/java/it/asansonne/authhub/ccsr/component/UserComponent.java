package it.asansonne.authhub.ccsr.component;

import it.asansonne.common.ccsr.component.DeleteComponent;
import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.model.User;
import java.security.Principal;
import java.util.UUID;

/**
 * The interface User component.
 */
public interface UserComponent extends
    GetComponent<UserResponse>,
    PatchComponent<UserRequest>,
    PostComponent<UserRequest, UserResponse>,
    DeleteComponent
{
  User findUser(UUID userUuid);
  UserResponse me(Principal principal);
}
