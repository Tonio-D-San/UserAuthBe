package it.asansonne.management.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.management.ccsr.controller.PlayerController;
import it.asansonne.management.ccsr.service.AbilityDefinitionService;
import it.asansonne.management.dto.AbilityDefinitionDTO;
import it.asansonne.management.enumeration.AbilityName;
import it.asansonne.management.model.AbilityDefinition;
import it.asansonne.management.model.Player;
import it.asansonne.management.model.PlayerAbilities;
import java.util.List;
import java.util.Locale;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/players")
@AllArgsConstructor
public class PlayerControllerImpl implements PlayerController {



  private final AbilityDefinitionService service;

  @Override
  public Player findPlayerByAbility(AbilityName abilityName) {
    return Player.builder()
        .abilities(List.of(
            PlayerAbilities.builder().abilityName(abilityName).build()
        ))
        .build();
  }

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public Page<AbilityDefinitionDTO> findAll(
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "5") Integer size,
      @RequestParam(defaultValue = "asc") String direction,
      Locale locale
  ) {
    return service.findAll(page, size, direction, locale);
  }

  @GetMapping(value = "/{ability}", produces = MediaType.APPLICATION_JSON_VALUE)
  public AbilityDefinition findByAbility(
      @PathVariable("ability") AbilityName abilityName
  ) {
    return service.findAbilityDefinitionByCode(abilityName);
  }
}
