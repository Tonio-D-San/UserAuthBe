package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Training {
  EVALUATOR("evaluator.name", AbilityName.EVALUATE),
  TRAVELER("traveler.name", AbilityName.FINDING_COLLECTION_AREAS),
  MYSTIC("mystic.name", AbilityName.PERCEIVING_MAGIC),
  VECTOR("vector.name", AbilityName.RITUAL_VECTOR),
  INITIATE("initiate.name", AbilityName.HERMETIC_CIPHER),
  JUMP_DEALER("jump_dealer.name", AbilityName.COLLECTOR),
  EXPLORER("explorer.name", AbilityName.CARTOGRAPHER),
  ROGUE("rogue.name", AbilityName.QUICK_HAND),
  NURSE("nurse.name", AbilityName.FIRST_AID),
  HISTORIAN("historian.name", AbilityName.LOST_LANGUAGES_ONE),
  STORYTELLER("storyteller.name", AbilityName.MYTHS_LEGENDS_ONE),
  JOB_CRAFTSMAN_1("job_craftsman_one.name", AbilityName.CRAFTSMAN_ONE)
  ;

  private final String name;
  private final AbilityName abilityName;

}
