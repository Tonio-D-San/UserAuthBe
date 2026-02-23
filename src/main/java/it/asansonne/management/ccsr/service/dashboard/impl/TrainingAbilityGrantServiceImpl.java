package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.TrainingAbilityGrantRepository;
import it.asansonne.management.ccsr.service.dashboard.TrainingAbilityGrantService;
import it.asansonne.management.model.TrainingAbilityGrant;
import jakarta.persistence.EntityNotFoundException;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TrainingAbilityGrantServiceImpl implements TrainingAbilityGrantService {
  public static final String NOT_FOUND = "training.not.found";
  private final TrainingAbilityGrantRepository repository;

  @Override
  public Optional<TrainingAbilityGrant> findByUuid(UUID uuid) {
    return this.repository.findByUuid(uuid);
  }

  @Override
  public Page<TrainingAbilityGrant> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<TrainingAbilityGrant> trainings = this.repository.findAllByIsActive(isActive, pageable);
    if (trainings.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "trainings.active.empty" : "trainings.inactive.empty"
      );
    }
    return trainings;
  }

  @Override
  public Page<TrainingAbilityGrant> findAll(Pageable pageable, Locale locale) {
    Page<TrainingAbilityGrant> trainings = this.repository.findAll(pageable);
    if (trainings.isEmpty()) {
      throw new EntityNotFoundException("trainings.empty");
    }
    return trainings;
  }

  @Override
  public void update(TrainingAbilityGrant model) {
    this.create(findTrainingAbilityGrant(model.getUuid()));
  }

  public TrainingAbilityGrant update(TrainingAbilityGrant model, Consumer<TrainingAbilityGrant> mutator) {
    TrainingAbilityGrant training = findTrainingAbilityGrant(model.getUuid());
    mutator.accept(training);
    return repository.save(training);
  }

  @Override
  public TrainingAbilityGrant create(TrainingAbilityGrant model) {
    return this.repository.save(model);
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.repository.delete(findTrainingAbilityGrant(uuid));
  }

  private TrainingAbilityGrant findTrainingAbilityGrant(UUID uuid) {
    return this.findByUuid(uuid)
        .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
  }

}
