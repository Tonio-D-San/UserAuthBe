package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MoneyName implements Name {
  COPPER("copper", "c"),
  SILVER("silver", "s"),
  GOLD("gold", "g")
  ;

  private final String name;
  private final String abbreviation;

}
