package it.asansonne.management.ccsr.component.impl;

import it.asansonne.management.ccsr.component.AbilityComponent;
import it.asansonne.management.ccsr.service.AbilityDefinitionService;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AbilityComponentImpl implements AbilityComponent {
  private final AbilityDefinitionService service;

  @Override
  public AbilityResponse findByAbility(AbilityName ability) {
    return null;
  }

  @Override
  public AbilityResponse findByUuid(UUID uuid) {
    return null;
  }

  @Override
  public Page<AbilityResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<AbilityResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return null;
  }

  @Override
  public Page<AbilityResponse> findAllByField(Pageable pageable, AbilityRequest request) {
    return null;
  }

  @Override
  public void updateByUuid(UUID uuid, AbilityRequest request) {

  }

  @Override
  public AbilityResponse create(Principal principal, AbilityRequest request) {
    return null;
  }
}
