package it.asansonne.authhub.ccsr.repository.users;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.authhub.model.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends GetRepository<User> {

//  /**
//   * Find user by uuid optional.
//   *
//   * @param uuid the uuid
//   * @return the optional
//   */
//  Optional<User> findUserByUuid(UUID uuid);

  /**
   * Find by email optional.
   *
   * @param email the email
   * @return the optional
   */
  Optional<User> findByEmail(String email);

//  /**
//   * Find all by is active page.
//   *
//   * @param isActive it is active
//   * @param pageable the pageable
//   * @return the page
//   */
//  Page<User> findAllByIsActive(Boolean isActive, Pageable pageable);


}
