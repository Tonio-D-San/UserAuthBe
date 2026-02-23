package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.TrainingRepository;
import it.asansonne.management.ccsr.service.dashboard.TrainingService;
import it.asansonne.management.model.Training;
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
public class TrainingServiceImpl implements TrainingService {
  public static final String NOT_FOUND = "training.not.found";
  private final TrainingRepository repository;


  @Override
  public Optional<Training> findByName(String name) {
    return this.repository.findByName(name);
  }

  @Override
  public Optional<Training> findByUuid(UUID uuid) {
    return this.repository.findByUuid(uuid);
  }

  @Override
  public Page<Training> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<Training> trainings = this.repository.findAllByIsActive(isActive, pageable);
    if (trainings.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "trainings.active.empty" : "trainings.inactive.empty"
      );
    }
    return trainings;
  }

  @Override
  public Page<Training> findAll(Pageable pageable, Locale locale) {
    Page<Training> trainings = this.repository.findAll(pageable);
    if (trainings.isEmpty()) {
      throw new EntityNotFoundException("trainings.empty");
    }
    return trainings;
  }

  @Override
  public void update(Training model) {
    this.create(findTraining(model.getUuid()));
  }

  public Training update(Training model, Consumer<Training> mutator) {
    Training training = findTraining(model.getUuid());
    mutator.accept(training);
    return repository.save(training);
  }

  @Override
  public Training create(Training model) {
    return this.repository.save(model);
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.repository.delete(findTraining(uuid));
  }

  private Training findTraining(UUID uuid) {
    return this.findByUuid(uuid)
        .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
  }

}
