package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.management.ccsr.component.TrainingAbilityGrantComponent;
import it.asansonne.management.ccsr.service.dashboard.TrainingAbilityGrantService;
import it.asansonne.management.dto.request.TrainingAbilityGrantRequest;
import it.asansonne.management.dto.response.TrainingAbilityGrantResponse;
import it.asansonne.management.mapper.impl.TrainingAbilityGrantMapper;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class TrainingAbilityGrantComponentImpl implements TrainingAbilityGrantComponent {
  private final TrainingAbilityGrantService service;
  private final TrainingAbilityGrantMapper mapper;

  @Override
  public TrainingAbilityGrantResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(
        this.service.findByUuid(uuid)
            .orElseThrow(() -> new NotFoundException("realm.not.found", uuid))
    );
  }

  @Override
  public Page<TrainingAbilityGrantResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<TrainingAbilityGrantResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, TrainingAbilityGrantRequest request) {

    this.service.update(this.mapper.toModel(request));
  }

  @Override
  public TrainingAbilityGrantResponse create(Principal principal, TrainingAbilityGrantRequest request) {
    log.info("request: {}", request);
    return this.mapper.toDto(
        this.service.create(
            this.mapper.toModel(request)
        )
    );
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.service.deleteByUuid(uuid);
  }

}
