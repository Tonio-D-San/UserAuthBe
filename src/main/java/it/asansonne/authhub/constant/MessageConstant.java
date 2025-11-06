package it.asansonne.authhub.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The interface Message constant.
 */
@Getter
@AllArgsConstructor
public enum MessageConstant {
  USER_NOT_FOUND("No user found"),
  USER_EMPTY("User list is empty"),
  USER_INACTIVE_EMPTY ("User inactive list is empty"),
  USER_ACTIVE_EMPTY ("User active list is empty"),
  FORBIDDEN ("Access is prohibited"),
  JWT_ERROR ("No valid JWT token found in the security context"),
  GROUP_EMPTY ("Group list is empty"),
  GROUP_NOT_FOUND ("No group found"),
  NOT_ALLOWED ("Method not allowed"),
  STORY_NOT_FOUND ("No story found"),
  STORY_EMPTY ("Story list is empty"),
  STORY_ACTIVE_EMPTY ("Story active list is empty"),
  STORY_INACTIVE_EMPTY ("Story active list is empty");

  private final String message;
}
