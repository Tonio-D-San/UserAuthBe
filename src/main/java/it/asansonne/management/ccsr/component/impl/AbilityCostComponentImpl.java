package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.management.ccsr.component.AbilityCostComponent;
import it.asansonne.management.ccsr.service.dashboard.AbilityCostService;
import it.asansonne.management.dto.request.AbilityCostRequest;
import it.asansonne.management.dto.response.AbilityCostResponse;
import it.asansonne.management.mapper.impl.AbilityCostMapper;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AbilityCostComponentImpl implements AbilityCostComponent {
  private final AbilityCostService service;
  private final AbilityCostMapper mapper;

  @Override
  public AbilityCostResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(
        this.service.findByUuid(uuid)
            .orElseThrow(() -> new NotFoundException("ability.not.found", uuid))
    );
  }

  @Override
  public Page<AbilityCostResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<AbilityCostResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, AbilityCostRequest request) {
    this.service.update(this.mapper.toModel(request));
  }

  @Override
  public AbilityCostResponse create(Principal principal, AbilityCostRequest request) {
    return this.service.create(this.mapper.toModel(request)) != null
        ? this.mapper.toDto(this.service.create(this.mapper.toModel(request)))
        : null;
  }
}
