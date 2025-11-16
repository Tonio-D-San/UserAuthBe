package it.asansonne.management.enumeration.calls;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Call {
  AMNESIA("call_amnesia.name", "call_amnesia.description"),
  BLINDNESS("call_blindness.name", "call_blindness.description"),
  CALLING("call_calling.name", "call_calling.description"),
  CHARME("call_charme.name", "call_charme.description"),
  CONFUSE("call_confuse.name", "call_confuse.description"),
  CRASH("call_crash.name", "call_crash.description"),
  DEATH_BLOW("call_death_blow.name", "call_death_blow.description"),
  DECAY("call_decay.name", "call_decay.description"),
  DISARM("call_disarm.name", "call_disarm.description"),
  DISPEL("call_dispel.name", "call_dispel.description"),
  DOMINATION("call_domination.name", "call_domination.description"),
  DOUBLE("call_double.name", "call_double.description"),
  DUEL("call_duel.name", "call_duel.description"),
  ENRAGE("call_enrage.name", "call_enrage.description"),
  FEAR("call_fear.name", "call_fear.description"),
  HEAL("call_heal.name", "call_heal.description"),
  MORTAL("call_mortal.name", "call_mortal.description"),
  NAUSEA("call_nausea.name", "call_nausea.description"),
  PAIN("call_pain.name", "call_pain.description"),
  PARALYZE("call_paralyze.name", "call_paralyze.description"),
  PETRIFY("call_petrify.name", "call_petrify.description"),
  REPAIR("call_repair.name", "call_repair.description"),
  REPEL("call_repel.name", "call_repel.description"),
  SILENCE("call_silence.name", "call_silence.description"),
  SLEEP("call_sleep.name", "call_sleep.description"),
  SMITE("call_smite.name", "call_smite.description"),
  STRIKE_DOWN("call_strike_down.name", "call_strike_down.description"),
  STUN("call_stun.name", "call_stun.description"),
  THROUGH("call_through.name", "call_through.description"),
  WEAKNESS("call_weakness.name", "call_weakness.description")
  ;

  private final String name;
  private final String description;
}
