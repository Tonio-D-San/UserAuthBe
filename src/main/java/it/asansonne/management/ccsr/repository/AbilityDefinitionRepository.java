package it.asansonne.management.ccsr.repository;

import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.AbilityDefinition;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityDefinitionRepository extends JpaRepository<AbilityDefinition, AbilityName> {
  Optional<AbilityDefinition> findAbilityDefinitionByCode(AbilityName code);
}
