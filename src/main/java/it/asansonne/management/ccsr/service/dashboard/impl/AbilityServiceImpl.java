package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.AbilityRepository;
import it.asansonne.management.ccsr.service.dashboard.AbilityService;
import it.asansonne.management.model.Ability;
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
public class AbilityServiceImpl implements AbilityService {
  private final AbilityRepository repository;

  @Override
  public Optional<Ability> findByUuid(UUID uuid) {
    return repository.findByUuid(uuid);
  }

  @Override
  public Page<Ability> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<Ability> abilities = this.repository.findAllByIsActive(isActive, pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "abilities.active.empty" : "abilities.inactive.empty"
      );
    }
    return abilities;
  }

  @Override
  public Page<Ability> findAll(Pageable pageable, Locale locale) {
    Page<Ability> abilities = this.repository.findAll(pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException("abilities.empty");
    }
    return abilities;
  }

  @Override
  public Page<Ability> findAllByField(Pageable pageable) {
    return this.repository.findAll(pageable);
  }

  @Override
  public void update(Ability model) {
    this.create(model);
  }

  @Override
  public Ability create(Ability model) {
    return this.repository.save(model);
  }

}
