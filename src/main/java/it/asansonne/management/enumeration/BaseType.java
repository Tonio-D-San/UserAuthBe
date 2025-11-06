package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseType implements Name {
  COMMON("common", "C"),
  RARE("rare", "R"),
  UNIQUE("unique", "U")
  ;
  private final String name;
  private final String abbreviation;
}
