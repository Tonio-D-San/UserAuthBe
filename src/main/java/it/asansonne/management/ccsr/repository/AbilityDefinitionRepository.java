package it.asansonne.management.ccsr.repository;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.Ability;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityDefinitionRepository extends
    GetRepository<Ability> {
  //    extends JpaRepository<Ability, AbilityName> {
  Optional<Ability> findAbilityDefinitionByCode(AbilityName code);
}
