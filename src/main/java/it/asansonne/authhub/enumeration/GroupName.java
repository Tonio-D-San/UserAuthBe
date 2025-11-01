package it.asansonne.authhub.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupName {
  ADMIN("admin-service-administrators"),
  USER("user-service-administrators");

  private final String name;
}
