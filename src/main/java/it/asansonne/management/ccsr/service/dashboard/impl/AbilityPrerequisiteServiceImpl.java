package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.AbilityPrerequisiteRepository;
import it.asansonne.management.ccsr.service.dashboard.AbilityPrerequisiteService;
import it.asansonne.management.model.AbilityPrerequisite;
import jakarta.persistence.EntityNotFoundException;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AbilityPrerequisiteServiceImpl implements AbilityPrerequisiteService {
  private final AbilityPrerequisiteRepository repository;

  @Override
  public Optional<AbilityPrerequisite> findByUuid(UUID uuid) {
    return repository.findByUuid(uuid);
  }

  @Override
  public Page<AbilityPrerequisite> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<AbilityPrerequisite> abilities = this.repository.findAllByIsActive(isActive, pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "abilities.active.empty" : "abilities.inactive.empty"
      );
    }
    return abilities;
  }

  @Override
  public Page<AbilityPrerequisite> findAll(Pageable pageable, Locale locale) {
    Page<AbilityPrerequisite> abilities = this.repository.findAll(pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException("abilities.empty");
    }
    return abilities;
  }

  @Override
  public Page<AbilityPrerequisite> findAllByField(Pageable pageable) {
    return this.repository.findAll(pageable);
  }

  @Override
  public void update(AbilityPrerequisite model) {
    this.create(model);
  }

  @Override
  public AbilityPrerequisite create(AbilityPrerequisite model) {
    return this.repository.save(model);
  }

}
