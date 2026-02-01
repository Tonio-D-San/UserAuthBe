package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.AbilityCostRepository;
import it.asansonne.management.ccsr.service.dashboard.AbilityCostService;
import it.asansonne.management.model.AbilityCost;
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
public class AbilityCostServiceImpl implements AbilityCostService {
  private final AbilityCostRepository repository;

  @Override
  public Optional<AbilityCost> findByUuid(UUID uuid) {
    return repository.findByUuid(uuid);
  }

  @Override
  public Page<AbilityCost> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<AbilityCost> abilities = this.repository.findAllByIsActive(isActive, pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "abilities.active.empty" : "abilities.inactive.empty"
      );
    }
    return abilities;
  }

  @Override
  public Page<AbilityCost> findAll(Pageable pageable, Locale locale) {
    Page<AbilityCost> abilities = this.repository.findAll(pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException("abilities.empty");
    }
    return abilities;
  }

  @Override
  public Page<AbilityCost> findAllByField(Pageable pageable) {
    return this.repository.findAll(pageable);
  }

  @Override
  public void update(AbilityCost model) {
    this.create(model);
  }

  @Override
  public AbilityCost create(AbilityCost model) {
    return this.repository.save(model);
  }

}
