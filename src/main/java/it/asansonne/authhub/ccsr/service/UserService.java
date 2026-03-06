package it.asansonne.authhub.ccsr.service;

import it.asansonne.common.ccsr.service.DeleteService;
import it.asansonne.common.ccsr.service.GetService;
import it.asansonne.common.ccsr.service.PatchService;
import it.asansonne.common.ccsr.service.PostService;
import it.asansonne.authhub.model.User;

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
