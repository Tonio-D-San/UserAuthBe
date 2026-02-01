package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.ConflictException;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.management.ccsr.component.TrainingComponent;
import it.asansonne.management.ccsr.component.RulesetComponent;
import it.asansonne.management.ccsr.service.dashboard.TrainingService;
import it.asansonne.management.dto.request.TrainingRequest;
import it.asansonne.management.dto.response.TrainingResponse;
import it.asansonne.management.mapper.impl.TrainingMapper;
import it.asansonne.management.model.Training;
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
public class TrainingComponentImpl implements TrainingComponent {
  private final TrainingService service;
  private final TrainingMapper mapper;
  private final RulesetComponent rulesetComponent;

  @Override
  public TrainingResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(
        this.service.findByUuid(uuid)
            .orElseThrow(() -> new NotFoundException("realm.not.found", uuid))
    );
  }

  @Override
  public Page<TrainingResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<TrainingResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<TrainingResponse> findAllByField(Pageable pageable, TrainingRequest request) {
    return this.mapper.toDto(this.service.findAllByField(pageable), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, TrainingRequest request) {

    this.service.update(this.mapper.toModel(request));
  }

  @Override
  public TrainingResponse create(Principal principal, TrainingRequest request) {
    log.info("request: {}", request);
    String name = request.getName();
    if (!name.toUpperCase().matches("^[A-Z0-9_]+$")) {
      throw new IllegalArgumentException("Invalid realm code");
    }
    if (this.service.findByName(name).isPresent()) {
      throw new ConflictException("Training name already exists");
    }
    Training realm = this.mapper.toModel(request);
    realm.setRuleset(rulesetComponent.getModel(request.getRulesetUuid()));
    return this.mapper.toDto(
        this.service.create(realm)
    );
  }

  @Override
  public TrainingResponse findByName(String name) {
    return this.mapper.toDto(
        this.service.findByName(name)
            .orElseThrow(() -> new NotFoundException("realm.not.found"))
    );
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.service.deleteByUuid(uuid);
  }

}
