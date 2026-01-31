package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.management.ccsr.component.AbilityComponent;
import it.asansonne.management.ccsr.service.dashboard.AbilityService;
import it.asansonne.management.dto.request.AbilityRequest;
import it.asansonne.management.dto.response.AbilityResponse;
import it.asansonne.management.mapper.impl.AbilityMapper;
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
  private final AbilityService service;
  private final AbilityMapper mapper;

  @Override
  public AbilityResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(
        this.service.findByUuid(uuid)
            .orElseThrow(() -> new NotFoundException("ability.not.found", uuid))
    );
  }

  @Override
  public Page<AbilityResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<AbilityResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<AbilityResponse> findAllByField(Pageable pageable, AbilityRequest request) {
    return this.mapper.toDto(this.service.findAllByField(pageable), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, AbilityRequest request) {
    this.service.update(this.mapper.toModel(request));
  }

  @Override
  public AbilityResponse create(Principal principal, AbilityRequest request) {
    return this.service.create(this.mapper.toModel(request)) != null
        ? this.mapper.toDto(this.service.create(this.mapper.toModel(request)))
        : null;
  }
}
