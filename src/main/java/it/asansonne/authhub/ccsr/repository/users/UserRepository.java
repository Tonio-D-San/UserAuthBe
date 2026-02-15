package it.asansonne.authhub.ccsr.repository.users;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.authhub.model.users.User;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends
    GetRepository<User>
{

}
