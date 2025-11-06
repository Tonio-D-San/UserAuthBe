package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AbilityName implements Name {
  // GENERIC ABILITIES
  CARTOGRAPHER("cartographer.name", "cartographer.description"),
  MARSHAL("marshall.name", "marshall.description"),
  HERMETIC_CIPHER("hermetic_cipher.name", "hermetic_cipher.description"),
  COLLECTOR("collector.name", "collector.description"),
  CONSTITUTION("constitution.name", "constitution.description"),
  IMPROVED_CONSTITUTION("improved_constitution.name", "improved_constitution.description"),
  DISARM_TRAPS("disarm_traps.name", "disarm_traps.description"),
  LOST_LANGUAGES_ONE("lost_languages_one.name", Constants.LOST_LANGUAGES_DESCRIPTION),
  LOST_LANGUAGES_TWO("lost_languages_two.name", Constants.LOST_LANGUAGES_DESCRIPTION),
  LOST_LANGUAGES_THREE("lost_languages_three.name", Constants.LOST_LANGUAGES_DESCRIPTION),
  SECRET_LANGUAGES_ONE("secret_languages_one.name", Constants.SECRET_LANGUAGES_DESCRIPTION),
  SECRET_LANGUAGES_TWO("secret_languages_two.name", Constants.SECRET_LANGUAGES_DESCRIPTION),
  SECRET_LANGUAGES_THREE("secret_languages_three.name", Constants.SECRET_LANGUAGES_DESCRIPTION),
  QUICK_HAND("quick_hand.name", "quick_hand.description"),
  MYTHS_LEGENDS_ONE("myths_legends_one.name", Constants.MYTHS_LEGENDS_DESCRIPTION),
  MYTHS_LEGENDS_TWO("myths_legends_two.name", Constants.MYTHS_LEGENDS_DESCRIPTION),
  MYTHS_LEGENDS_THREE("myths_legends_three.name", Constants.MYTHS_LEGENDS_DESCRIPTION),
  TENACITY("tenacity.name", "tenacity.description"),
  TENACIOUS_VOICE("tenacious_voice.name", "tenacious_voice.description"),
  TENACIOUS_STEP("tenacious_step.name", "tenacious_step.description"),
  PERCEIVING_MAGIC("perceiving_magic.name", "perceiving_magic.description"),
  REFINE_ALATHIUM("refine_alathium.name", "refine_alathium.description"),
  LOCKPICKING("lockpicking.name", "lockpicking.description"),
  EVALUATE("evaluate.name", "evaluate.description"),
  RITUAL_VECTOR("ritual_vector.name", "ritual_vector.description"),
  //ALCHEMY
  ALCHEMY_ONE("alchemy_one.name", "alchemy_one.description"),
  ALCHEMY_TWO("alchemy_two.name", "alchemy_two.description"),
  ALCHEMY_THREE("alchemy_three.name", "alchemy_three.description"),
  ALCHEMICAL_CROSSROADS("alchemical_crossroads.name", "alchemical_crossroads.description"),
  IMMUNOLOGIST("immunologist.name", "immunologist.description"),
  //EXTRACTION
  HERBAL_MEDICINE_ONE("herbal_medicine_one.name", Constants.HERBAL_MEDICINE_DESCRIPTION),
  HERBAL_MEDICINE_TWO("herbal_medicine_two.name", Constants.HERBAL_MEDICINE_DESCRIPTION),
  HERBAL_MEDICINE_THREE("herbal_medicine_three.name", Constants.HERBAL_MEDICINE_DESCRIPTION),
  MINERALOGY_ONE("mineralogy_one.name", Constants.MINERALOGY_DESCRIPTION),
  MINERALOGY_TWO("mineralogy_two.name", Constants.MINERALOGY_DESCRIPTION),
  MINERALOGY_THREE("mineralogy_three.name", Constants.MINERALOGY_DESCRIPTION),
  FINDING_COLLECTION_AREAS("finding_collection_areas.name", "finding_collection_areas.description"),
  HERBAL_TRASMUTATION("herbal_transmutation.name", "herbal_transmutation.description"),
  MINERAL_TRANSMUTATION("mineral_transmutation.name", "mineral_transmutation.description"),
  //CRAFTSMANSHIP
  CRAFTSMAN_ONE("craftsman_one.name", "craftsman_one.description"),
  CRAFTSMAN_TWO("craftsman_two.name", "craftsman_two.description"),
  CRAFTSMAN_THREE("craftsman_three.name", "craftsman_three.description"),
  MYSTIC_SMITH("mystic_smith.name", "mystic_smith.description"),
  ARTIFICER_ONE("artificer_one.name", "artificer_one.description"),
  ARTIFICER_TWO("artificer_two.name", "artificer_two.description"),
  ARTIFICER_THREE("artificer_three.name", "artificer_three.description"),
  //COMBAT
  LIGHT_ARMOR("light_armor.name", "light_armor.description"),
  MEDIUM_ARMOR("medium_armor.name", "medium_armor.description"),
  HEAVY_ARMOR("heavy_armor.name", "heavy_armor.description"),
  MASTERY_TWO_HANDED_WEAPONS("mastery_two_handed_weapons.name", "mastery_two_handed_weapons.description"),
  MASTERY_ONE_HANDED_WEAPONS_SHORT("mastery_one_handed_weapons_short.name", "mastery_one_handed_weapons_short.description"),
  MASTERY_ONE_HANDED_WEAPONS("mastery_one_handed_weapons.name", "mastery_one_handed_weapons.description"),
  MASTERY_FIREARMS("mastery_firearms.name", "mastery_firearms.description"),
  MASTERY_THROWING_WEAPONS("mastery_throwing_weapons.name", "mastery_throwing_weapons.description"),
  MASTERY_SHOOTING_WEAPONS("mastery_shooting_weapons.name", "mastery_shooting_weapons.description"),
  MASTERY_SHIELD("mastery_shield.name", "mastery_shield.description"),
  BREATHING("breathing.name", "breathing.description"),
  IMPROVED_BREATHING("improved_breathing.name", "improved_breathing.description"),
  //RECOVERY
  FIRST_AID("first_aid.name", "first_aid.description"),
  EXPERT_RESCUER("expert_rescuer.name", "expert_rescuer.description"),
  HEALING_ARTS("healing_arts.name", "healing_arts.description"),
  SURGEON("surgeon.name", "surgeon.description"),
  FIELD_SURGEON_ONE("field_surgeon_one.name", "field_surgeon_one.description"),
  FIELD_SURGEON_TWO("field_surgeon_two.name", "field_surgeon_two.description"),
  FIELD_SURGEON_THREE("field_surgeon_three.name", "field_surgeon_three.description"),
  FIELD_EXPEDIENTS_ONE("field_expedient_one.name", "field_expedient_one.description"),
  FIELD_EXPEDIENTS_TWO("field_expedient_two.name", "field_expedient_two.description"),
  FIELD_EXPEDIENTS_THREE("field_expedient_three.name", "field_expedient_three.description"),
  TENACIOUS_HEALER("tenacious_healer.name", "tenacious_healer.description"),
  TOXICOLOGIST("toxicologist.name", "toxicologist.description"),
  //MAGIC
  MAGICAL_CONTAMINATION("magical_contamination.name", "magical_contamination.description"),
  POWER_GIFT("power_gift.name", "power_gift.description"),
  ENCHANTER_ONE("enchanter_one.name", "enchanter_one.description"),
  ENCHANTER_TWO("enchanter_two.name", "enchanter_two.description"),
  ENCHANTER_THREE("enchanter_three.name", "enchanter_three.description"),
  LIGHT_ENCHANTER("light_enchanter.name", "light_enchanter.description"),
  BATTLE_ENCHANTER("battle_enchanter.name", "battle_enchanter.description"),
  WAR_ENCHANTER("war_enchanter.name", "war_enchanter.description"),
  //RITUALIST
  RITUALIST_ONE("ritualist_one.name", "ritualist_one.description"),
  RITUALIST_TWO("ritualist_two.name", "ritualist_two.description"),
  RITUALIST_THREE("ritualist_three.name", "ritualist_three.description"),
  //YIELD
  HERBAL_INCOME_ONE("herbal_income_one.name", "herbal_income_one.description"),
  HERBAL_INCOME_TWO("herbal_income_two.name", "herbal_income_two.description"),
  HERBAL_INCOME_THREE("herbal_income_three.name", "herbal_income_three.description"),
  MINERAL_INCOME_ONE("mineral_income_one.name", "mineral_income_one.description"),
  MINERAL_INCOME_TWO("mineral_income_two.name", "mineral_income_two.description"),
  MINERAL_INCOME_THREE("mineral_income_three.name", "mineral_income_three.description"),
  MONEY_INCOME_ONE("money_income_one.name", "money_income_one.description"),
  MONEY_INCOME_TWO("money_income_two.name", "money_income_two.description"),
  MONEY_INCOME_THREE("money_income_three.name", "money_income_three.description"),
  FENCE("fence.name", "fence.description");

  private final String name;
  private final String description;

  private static class Constants {
    public static final String LOST_LANGUAGES_DESCRIPTION = "lost_languages.description";
    public static final String SECRET_LANGUAGES_DESCRIPTION = "secret_languages.description";
    public static final String MYTHS_LEGENDS_DESCRIPTION = "myths_legends.description";
    public static final String HERBAL_MEDICINE_DESCRIPTION = "herbal_medicine.description";
    public static final String MINERALOGY_DESCRIPTION = "mineralogy.description";
  }
}
