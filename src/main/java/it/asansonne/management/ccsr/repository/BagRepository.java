package it.asansonne.management.ccsr.repository;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.management.model.Bag;
import it.asansonne.management.model.Character;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends
    GetRepository<Bag> {
  Optional<Bag> findBagByOwner(Character owner);
}
