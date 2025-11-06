package it.asansonne.authhub.ccsr.component;

import it.asansonne.authhub.model.Group;
import it.asansonne.authhub.model.User;
import it.asansonne.authhub.dto.request.StatusRequest;
import it.asansonne.authhub.dto.request.UserRequest;
import java.util.UUID;

/**
 * The interface Keycloak component.
 */
public interface KeycloakComponent {

  /**
   * Read user user.
   *
   * @param email the email
   * @return the user
   */
  User readUser(String email);

  /**
   * Create a user.
   *
   * @param request the request
   */
  void createUser(UserRequest request);

  /**
   * Update user.
   *
   * @param userUuid the user uuid
   * @param request  the request
   */
  void updateUser(UUID userUuid, Group request);

  /**
   * Update status user.
   *
   * @param userUuid the user uuid
   * @param status   the status
   */
  void updateStatusUser(UUID userUuid, StatusRequest status);

  /**
   * Delete user group.
   *
   * @param userUuid the user uuid
   * @param group    the group
   */
  void deleteUserGroup(UUID userUuid, Group group);
}
