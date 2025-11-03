package it.asansonne.management.ccsr.repository;

import it.asansonne.management.enumeration.AbilityName;
import it.asansonne.management.model.AbilityDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityDefinitionRepository extends JpaRepository<AbilityDefinition, AbilityName> {
  AbilityName getAbilityName();
}
