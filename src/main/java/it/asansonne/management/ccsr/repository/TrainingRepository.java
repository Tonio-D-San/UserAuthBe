package it.asansonne.management.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.management.model.Training;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends
    GetRepository<Training>
{
  Optional<Training> findByRulesetUuid(UUID rulesetUuid);
  
  Optional<Training> findByName(String name);

  boolean existsByRulesetUuidAndNameIgnoreCase(UUID rulesetUuid, String name);

}
