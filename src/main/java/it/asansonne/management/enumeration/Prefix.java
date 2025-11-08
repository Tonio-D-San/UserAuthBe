package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Prefix {
  BATTLE("prefix_battle.name", "prefix_battle.description"),
  POISON("prefix_poison.name", "prefix_poison.description"),
  MASTER("prefix_master.name", "prefix_master.description"),
  MASS("prefix_mass.name", "prefix_mass.description"),
  PARCO_GIOCATORI("prefix_parco_giocatori.name", "prefix_parco_giocatori.description")
  ;

  private final String name;
  private final String description;
}