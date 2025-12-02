package it.asansonne.authhub.ccsr.repository.users;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.authhub.model.users.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends
    GetRepository<User>
{

  /**
   * Find by email optional.
   *
   * @param email the email
   * @return the optional
   */
  Optional<User> findByEmail(String email);

}
