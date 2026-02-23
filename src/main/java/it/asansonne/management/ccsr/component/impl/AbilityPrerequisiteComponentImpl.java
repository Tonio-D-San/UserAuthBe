package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.management.ccsr.component.AbilityPrerequisiteComponent;
import it.asansonne.management.ccsr.service.dashboard.AbilityPrerequisiteService;
import it.asansonne.management.dto.request.AbilityPrerequisiteRequest;
import it.asansonne.management.dto.response.AbilityPrerequisiteResponse;
import it.asansonne.management.mapper.impl.AbilityPrerequisiteMapper;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AbilityPrerequisiteComponentImpl implements AbilityPrerequisiteComponent {
  private final AbilityPrerequisiteService service;
  private final AbilityPrerequisiteMapper mapper;

  @Override
  public AbilityPrerequisiteResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(
        this.service.findByUuid(uuid)
            .orElseThrow(() -> new NotFoundException("ability.not.found", uuid))
    );
  }

  @Override
  public Page<AbilityPrerequisiteResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<AbilityPrerequisiteResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, AbilityPrerequisiteRequest request) {
    this.service.update(this.mapper.toModel(request));
  }

  @Override
  public AbilityPrerequisiteResponse create(Principal principal, AbilityPrerequisiteRequest request) {
    return this.service.create(this.mapper.toModel(request)) != null
        ? this.mapper.toDto(this.service.create(this.mapper.toModel(request)))
        : null;
  }
}
