package it.asansonne.management.ccsr.controller;

import it.asansonne.management.enumeration.AbilityName;
import it.asansonne.management.model.Player;

public interface PlayerController {
  Player findPlayerByAbility(AbilityName abilityName);
}
