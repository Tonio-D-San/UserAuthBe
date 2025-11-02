package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReagentName implements Name {
  REAGENT_A("Reagent A", "A"),
  REAGENT_B("Reagent B", "B")
  ;
  private final String name;
  private final String abbreviation;
}
