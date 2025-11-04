package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AbilityName implements Name {
  CARTOGRAPHER("cartographer.name"),
  MARSHAL("marshall.name"),
  HERMETIC_CIPHER("hermetic_cipher.name"),
  COLLECTOR("collector.name"),
  CONSTITUTION("constitution.name"),
  IMPROVED_CONSTITUTION("improved_constitution.name"),
  DISARM_TRAPS("disarm_traps.name"),
  LOST_LANGUAGES_ONE("lost_languages_one.name"),
  LOST_LANGUAGES_TWO("lost_languages_two.name"),
  LOST_LANGUAGES_THREE("lost_languages_three.name"),
  SECRET_LANGUAGES_ONE("secret_languages_one.name"),
  SECRET_LANGUAGES_TWO("secret_languages_two.name"),
  SECRET_LANGUAGES_THREE("secret_languages_three.name"),
  QUICK_HAND("quick_hand.name"),
  MYTHS_LEGENDS_ONE("myths_legends_one.name"),
  MYTHS_LEGENDS_TWO("myths_legends_two.name"),
  MYTHS_LEGENDS_THREE("myths_legends_three.name"),
  TENACITY("tenacity.name"),
  TENACIOUS_VOICE("tenacious_voice.name"),
  TENACIOUS_STEP("tenacious_step.name"),
  PERCEIVING_MAGIC("perceiving_magic.name"),
  REFINE_ALATHIUM("refine_alathium.name"),
  LOCKPICKING("lockpicking.name"),
  EVALUATE("evaluate.name"),
  RITUAL_VECTOR("ritual_vector.name");

  private final String name;

}
