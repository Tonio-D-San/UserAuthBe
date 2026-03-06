package it.asansonne.management.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.management.model.Ability;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends
    GetRepository<Ability>
{
  boolean existsByRulesetUuidAndCodeIgnoreCase(UUID rulesetUuid, String code);

  Page<Ability> findAllByRulesetUuid(UUID rulesetUuid, Pageable pageable);

}
