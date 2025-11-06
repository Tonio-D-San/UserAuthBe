package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KingdomName {
  CORONOR("Coronor", "C", "coronor.battle_cry"),
  LEVALIA("Levalia", "L", "levalia.battle_cry"),
  MALATEA("Malatea", "M", "malatea.battle_cry"),
  PORTUMBRIA("Portumbria", "P", "portumbria.battle_cry"),
  TAL_MERIDIA("Tal-Meridia", "T", "talmeridia.battle_cry"),
  VALMORA("Valmora", "V", "valmora.battle_cry")
  ;

  private final String name;
  private final String abbreviation;
  private final String maxim;

}
