package it.asansonne.authhub.ccsr.component.users;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.model.User;
import java.util.UUID;

/**
 * The interface User component.
 */
public interface UserComponent extends
    GetComponent<UserRequest, UserResponse>,
    PatchComponent<UserRequest, UserResponse>,
    PostComponent<UserRequest, UserResponse>
{
  User findUser(UUID userUuid);
  /**
   * Find user by uuid user response.
   *
   * @param userUuid the user uuid
   * @return the user response
   */
//  UserResponse findUserByUuid(UUID userUuid);

  /**
   * Find all user's pages.
   *
   * @param pageable the pageable
   * @return the page
   */
//  Page<UserResponse> findAllUsers(Pageable pageable);

//  /**
//   * Find active users page.
//   *
//   * @param isActive the is active
//   * @param pageable the pageable
//   * @return the page
//   */
//  Page<UserResponse> findActiveUsers(Boolean isActive, Pageable pageable);

  /**
   * Create user user response.
   *
   * @param userRequest the user request
   * @return the user response
   */
//  UserResponse createUser(@Valid UserRequest userRequest);

  /**
   * Update status user.
   *
   * @param userUuid the user uuid
   * @param status   the user status
   */
//  void updateStatusUserByUuid(UUID userUuid, StatusRequest status);

}
