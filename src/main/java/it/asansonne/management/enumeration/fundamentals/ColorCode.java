package it.asansonne.management.enumeration.fundamentals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ColorCode {
  BLU_STRIP("Fascia blu", "Bl"),
  RED_STRIP("Fascia rossa", "Ro"),
  PURPLE_STRIP("Fascia viola", "Vi"),
  YELLOW_STRIP("Fascia gialla", "Gi"),
  SILVER_STRIP("Fascia argentata", "Ar"),
  GREEN_ANVELOPE("Busta verde", "Ve"),
  WHITE_CARDS("Cartellini Bianchi", "Cb"),
  YELLOW_CARDS("Cartellini Gialli", "Cg")
  ;
  private final String code;
  private final String abbreviation;
}
