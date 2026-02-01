package it.asansonne.management.ccsr.repository;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.management.model.TrainingAbilityGrant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingAbilityGrantRepository extends
    GetRepository<TrainingAbilityGrant>
{
  Optional<TrainingAbilityGrant> findByTrainingUuid(UUID trainingUuid);

  List<TrainingAbilityGrant> findAllByTrainingUuid(UUID trainingUuid);

  Optional<TrainingAbilityGrant> findByTrainingUuidAndAbilityUuid(UUID trainingUuid, UUID abilityUuid);

  void deleteAllByTrainingUuid(UUID trainingUuid);
}
