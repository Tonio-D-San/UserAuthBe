package it.asansonne.management.ccsr.repository;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.management.model.Ruleset;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface RulesetRepository extends
    GetRepository<Ruleset>
{
  Optional<Ruleset> findByCode(String code);

  Optional<Ruleset> findTopByCodeOrderByVersionDesc(String code);

}
