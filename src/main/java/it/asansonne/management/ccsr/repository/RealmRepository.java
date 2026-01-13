package it.asansonne.management.ccsr.repository;

import it.asansonne.management.enumeration.character.RealmName;
import it.asansonne.management.model.Realm;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealmRepository extends JpaRepository<Realm, Long> {
  Optional<Realm> findByUuid(UUID uuid);

  Optional<Realm> findByRealmName(RealmName realmName);

}
