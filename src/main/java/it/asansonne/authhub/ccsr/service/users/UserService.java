package it.asansonne.authhub.ccsr.service.users;

import it.asansonne.authhub.ccsr.service.DeleteService;
import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.authhub.model.users.User;

/**
 * The interface User service.
 */
public interface UserService extends
    GetService<User>,
    PatchService<User>,
    PostService<User>,
    DeleteService
{

}
