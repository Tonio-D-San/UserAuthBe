package it.asansonne.authhub.ccsr.component.users;

import it.asansonne.authhub.ccsr.component.DeleteComponent;
import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.model.users.User;
import java.util.UUID;

/**
 * The interface User component.
 */
public interface UserComponent extends
    GetComponent<UserRequest, UserResponse>,
    PatchComponent<UserRequest, UserResponse>,
    PostComponent<UserRequest, UserResponse>,
    DeleteComponent
{
  User findUser(UUID userUuid);

}
