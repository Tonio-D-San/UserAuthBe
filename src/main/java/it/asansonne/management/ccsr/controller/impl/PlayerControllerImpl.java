package it.asansonne.management.ccsr.controller.impl;

import it.asansonne.management.ccsr.controller.PlayerController;
import it.asansonne.management.enumeration.AbilityName;
import it.asansonne.management.model.Ability;
import it.asansonne.management.model.Player;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PlayerControllerImpl implements PlayerController {

  private final MessageSource messageSource;

  @Override
  public Player findPlayerByAbility(AbilityName abilityName) {
    return Player.builder()
        .abilities(List.of(
            Ability.builder().abilityName(abilityName).build()
        ))
        .build();
  }
}
