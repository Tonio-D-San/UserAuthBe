package it.asansonne.management.ccsr.controller.dashboard.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.management.ccsr.component.AbilityComponent;
import it.asansonne.management.ccsr.controller.dashboard.AbilityController;
import it.asansonne.management.dto.AbilityDefinitionDTO;
import it.asansonne.management.dto.requests.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/abilities")
@AllArgsConstructor
public class AbilityControllerImpl implements AbilityController {

  private final AbilityComponent component;

  @Override
  public AbilityResponse findByUuid(UUID uuid) {
    return null;
  }

  @Override
  public Page<AbilityResponse> findActive(Integer page, Integer size, String direction,
                                          Boolean isActive) {
    return null;
  }

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public Page<AbilityResponse> findAll(
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "5") Integer size,
      @RequestParam(defaultValue = "asc") String direction,
      Locale locale
  ) {
    return component.findAll(page, size, direction, locale);
  }

  @Override
  public Page<AbilityResponse> findAllByField(Integer page, Integer size, String direction,
                                              AbilityRequest request) {
    return null;
  }

  @Override
  public AbilityResponse findLastAdded() {
    return null;
  }

  @GetMapping(value = "/{ability}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AbilityDefinitionDTO findByAbility(
        @PathVariable("ability") AbilityName abilityName,
        Locale locale
    ) {
//      return component.findAbilityDefinitionByCode(abilityName, locale);
      return null;
  }
}
