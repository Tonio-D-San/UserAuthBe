package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AbilityName implements Name{
  CARTOGRAPHER("cartographer", "crt"),
  CONSTITUTION("constitution", "cd"),
  ;

  private final String name;
  private final String abbreviation;

}
