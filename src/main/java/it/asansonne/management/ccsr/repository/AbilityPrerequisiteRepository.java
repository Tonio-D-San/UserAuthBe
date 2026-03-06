package it.asansonne.management.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.management.model.AbilityPrerequisite;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityPrerequisiteRepository extends
    GetRepository<AbilityPrerequisite> {

  List<AbilityPrerequisite> findAllByAbilityUuid(UUID abilityUuid);

  Optional<AbilityPrerequisite> findByAbilityUuidAndRequiredAbilityUuid(
      UUID abilityUuid, UUID requiredAbilityUuid
  );
}
