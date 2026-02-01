package it.asansonne.management.ccsr.repository;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.management.model.AlchemyPath;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AlchemyPathRepository extends
    GetRepository<AlchemyPath>
{
  Optional<AlchemyPath> findByName(String name);

  Page<AlchemyPath> findAllByRulesetUuid(UUID rulesetUuid, Pageable pageable);

  boolean existsByRulesetUuidAndCodeIgnoreCase(UUID rulesetUuid, String code);
}
