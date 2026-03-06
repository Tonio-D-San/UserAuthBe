package it.asansonne.authhub.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.authhub.model.User;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends
    GetRepository<User>
{

}
