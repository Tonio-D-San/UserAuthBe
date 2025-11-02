package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KingdomName implements Name{
  CORONOR("Coronor", "C") {
    @Override
    public String battleCry() { return "He who runs on the cold, slips on shame."; }
  },
  LEVALIA("Levalia", "L") {
    @Override
    public String battleCry() { return "By the Light of the Plains!"; }
  },
  MALATEA("Malatea", "M") {
    @Override
    public String battleCry() { return "The Blood of the King!"; }
  },
  PORTUMBRIA("Portumbria", "P") {
    @Override
    public String battleCry() { return "The King's Fury!"; }
  },
  TAL_MERIDIA("Tal-Meridia", "T") {
    @Override
    public String battleCry() { return "The King's Reign!"; }
  },
  VALMORA("Valmora", "V") {
    @Override
    public String battleCry() { return "The King's Name!"; }
  }
  ;

  private final String name;
  private final String abbreviation;

  public static KingdomName fromName(String name) {
    for (KingdomName k : values()) {
      if (k.name.equalsIgnoreCase(name)) {
        return k;
      }
    }
    throw new IllegalArgumentException("Nessun regno trovato per: " + name);
  }

  public abstract String battleCry();
}
