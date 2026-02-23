package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
  DRAFT("draft.name"),
  ACTIVE("active.name"),
  PUBLISHED("published.name"),
  DEPRECATED("deprecated.name");
  private final String name;
}
