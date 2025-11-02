package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KingdomName implements Name{
  CORONOR("Coronor", "C") {
    @Override
    public String battleCry() { return "For the Crown!"; }
  },
  LEVALIA("Levalia", "C") {
    @Override
    public String battleCry() { return "By the Light of the Plains!"; }
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
