package it.asansonne.management.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.management.model.Realm;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface RealmRepository extends
    GetRepository<Realm>
{
  Optional<Realm> findByName(String name);
}
