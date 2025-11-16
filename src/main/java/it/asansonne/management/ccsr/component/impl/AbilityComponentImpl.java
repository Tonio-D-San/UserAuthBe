package it.asansonne.management.ccsr.component.impl;

import it.asansonne.management.ccsr.component.AbilityComponent;
import it.asansonne.management.ccsr.service.AbilityDefinitionService;
import it.asansonne.management.dto.response.AbilityResponse;
import java.util.Locale;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AbilityComponentImpl implements AbilityComponent {
  private final AbilityDefinitionService service;

  @Override
  public Page<AbilityResponse> findAll(Integer page, Integer size, String direction,
                                       Locale locale) {
    return service.findAll(page, size, direction, locale);
  }
}
