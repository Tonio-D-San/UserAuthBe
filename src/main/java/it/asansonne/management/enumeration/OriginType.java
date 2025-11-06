package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OriginType implements Name{
  PLANT_ORIGIN("plant_origin.name"),
  MINERAL_ORIGIN("mineral_origin.name"),
  PLANT_MINERAL_ORIGIN("plant_mineral_origin.name")
  ;
  private final String name;
}
