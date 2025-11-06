package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlchemicalMixturesType implements Name{
  BASIC("basic", "B"),
  NOVICE("novice", "N"),
  EXPERT("expert", "E"),
  MASTER("master", "M")
  ;

  private final String name;
  private final String code;
}
