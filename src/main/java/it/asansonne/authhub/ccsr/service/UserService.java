package it.asansonne.authhub.ccsr.service;

import it.asansonne.authhub.model.jpa.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The interface User service.
 */
public interface UserService {

  /**
   * Find user by uuid optional.
   *
   * @param userUuid the user uuid
   * @return the optional
   */
  Optional<User> findUserByUuid(UUID userUuid);

  /**
   * Find all user's page.
   *
   * @param pageable the pageable
   * @return the page
   */
  Page<User> findAllUsers(Pageable pageable);

  /**
   * Find active users page.
   *
   * @param pageable the pageable
   * @return the page
   */
  Page<User> findActiveUsers(Boolean isActive, Pageable pageable);

  /**
   * Find inactive users page.
   *
   * @param pageable the pageable
   * @return the page
   */
  Page<User> findInactiveUsers(Pageable pageable);

  User createUser(User user);

  /**
   * Update user.
   *
   * @param user the user
   */
  void updateUser(User user);
}
