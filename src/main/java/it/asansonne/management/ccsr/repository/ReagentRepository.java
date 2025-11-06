package it.asansonne.management.ccsr.repository;

import it.asansonne.management.enumeration.AbilityName;
import it.asansonne.management.enumeration.ReagentName;
import it.asansonne.management.model.AbilityDefinition;
import it.asansonne.management.model.Reagent;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReagentRepository extends JpaRepository<Reagent, Integer> {
  Optional<Reagent> findAbilityDefinitionByReagentName(ReagentName reagentName);
}
