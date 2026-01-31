package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.RulesetRepository;
import it.asansonne.management.ccsr.service.dashboard.RulesetService;
import it.asansonne.management.enumeration.Status;
import it.asansonne.management.model.Ruleset;
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
public class RulesetServiceImpl implements RulesetService {
  private final RulesetRepository repository;

  @Override
  public Optional<Ruleset> findByUuid(UUID uuid) {
    return this.repository.findByUuid(uuid);
  }

  @Override
  public Page<Ruleset> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<Ruleset> abilities = this.repository.findAllByIsActive(isActive, pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "abilities.active.empty" : "abilities.inactive.empty"
      );
    }
    return abilities;
  }

  @Override
  public Page<Ruleset> findAll(Pageable pageable, Locale locale) {
    Page<Ruleset> abilities = this.repository.findAll(pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException("abilities.empty");
    }
    return abilities;
  }

  @Override
  public Page<Ruleset> findAllByField(Pageable pageable) {
    return this.repository.findAll(pageable);
  }

  @Override
  public void update(Ruleset model) {
    Ruleset ruleset =
        this.findByUuid(model.getUuid())
            .orElseThrow(() -> new EntityNotFoundException("ruleset.not.found"));
    model.setVersion(
        this.repository.findTopByCodeOrderByVersionDesc(ruleset.getCode())
            .map(Ruleset::getVersion).orElse(0) + 1
    );
  }

  @Override
  public Ruleset create(Ruleset model) {
    model.setVersion(1);
    return this.repository.save(model);
  }

  @Override
  public void status(UUID uuid, Status status) {
    this.findByUuid(uuid).ifPresent(ruleset ->
        ruleset.setStatus(status.toString())
    );
  }

  @Override
  public Optional<Ruleset> findByCode(String code) {
    return this.repository.findByCode(code.toUpperCase());
  }

  @Override
  public Ruleset deleteByUuid(UUID uuid) {
    Ruleset ruleset = this.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("ruleset.not.found"));
    this.repository.delete(ruleset);
    return ruleset;
  }

}
