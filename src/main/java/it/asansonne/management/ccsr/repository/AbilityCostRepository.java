package it.asansonne.management.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.management.model.AbilityCost;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityCostRepository extends
    GetRepository<AbilityCost>
{

  List<AbilityCost> findAllByAbilityUuid(UUID abilityUuid);

  Optional<AbilityCost> findByAbilityUuidAndRank(UUID abilityUuid, Integer rank);
}
