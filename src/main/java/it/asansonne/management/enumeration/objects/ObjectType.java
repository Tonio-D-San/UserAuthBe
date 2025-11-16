package it.asansonne.management.enumeration.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ObjectType {
  MAGIC_OBJECTS("Oggetto magico"),
  DEVICES("Ordigni"),
  MIXTURES("Misture"),
  SCROLLS("Pergamene"),
  PROTECTION_SEALS("Sigilli di protezione"),
  LOCKS("Serrature"),
  TRAPS("Trappole"),
  ALATHIUM_CRYSTALS("Cristalli di Alathium"),
  ;
  private final String name;
}
