package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KingdomName implements Name {
  CORONOR("Coronor", "C", "coronor.battlecry") {
    @Override
    public String battleCry() {
      return getMaxim();
    }
  },
  LEVALIA("Levalia", "L", "levalia.battlecry") {
    @Override
    public String battleCry() {
      return getMaxim();
    }
  },
  MALATEA("Malatea", "M", "malatea.battlecry") {
    @Override
    public String battleCry() {
      return getMaxim();
    }
  },
  PORTUMBRIA("Portumbria", "P", "portumbria.battlecry") {
    @Override
    public String battleCry() {
      return getMaxim();
    }
  },
  TAL_MERIDIA("Tal-Meridia", "T", "talmeridia.battlecry") {
    @Override
    public String battleCry() {
      return getMaxim();
    }
  },
  VALMORA("Valmora", "V", "valmora.battlecry") {
    @Override
    public String battleCry() {
      return getMaxim();
    }
  };

  private final String name;
  private final String abbreviation;
  private final String maxim;

  public abstract String battleCry();
}
