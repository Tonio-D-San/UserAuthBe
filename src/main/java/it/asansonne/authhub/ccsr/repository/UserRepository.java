package it.asansonne.authhub.ccsr.repository;

import it.asansonne.authhub.model.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  /**
   * Find user by uuid optional.
   *
   * @param uuid the uuid
   * @return the optional
   */
  Optional<User> findUserByUuid(UUID uuid);

  /**
   * Find by email optional.
   *
   * @param email the email
   * @return the optional
   */
  Optional<User> findByEmail(String email);

  /**
   * Find all by is active page.
   *
   * @param isActive it is active
   * @param pageable the pageable
   * @return the page
   */
  Page<User> findAllByIsActive(Boolean isActive, Pageable pageable);

  /**
   * Find all by is active false page.
   *
   * @param pageable the pageable
   * @return the page
   */
  Page<User> findAllByIsActiveFalse(Pageable pageable);
}
