package it.asansonne.authhub.ccsr.component;

import it.asansonne.authhub.dto.request.StatusRequest;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The interface User component.
 */
public interface UserComponent {

  /**
   * Find user by uuid user response.
   *
   * @param userUuid the user uuid
   * @return the user response
   */
  UserResponse findUserByUuid(UUID userUuid);

  /**
   * Find all user's pages.
   *
   * @param pageable the pageable
   * @return the page
   */
  Page<UserResponse> findAllUsers(Pageable pageable);

  /**
   * Find active users page.
   *
   * @param isActive the is active
   * @param pageable the pageable
   * @return the page
   */
  Page<UserResponse> findActiveUsers(Boolean isActive, Pageable pageable);

  /**
   * Create person user response.
   *
   * @param personRequest the person request
   * @return the user response
   */
  UserResponse createPerson(@Valid UserRequest personRequest);

  /**
   * Update status user.
   *
   * @param userUuid the user uuid
   * @param status   the user status
   */
  void updateStatusUserByUuid(UUID userUuid, StatusRequest status);

}
