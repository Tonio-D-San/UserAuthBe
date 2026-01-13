package it.asansonne.management.ccsr.repository;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.management.enumeration.ReagentName;
import it.asansonne.management.model.Reagent;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface ReagentRepository extends GetRepository<Reagent> {
  Optional<Reagent> findAbilityDefinitionByReagentName(ReagentName reagentName);
}
