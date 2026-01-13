package it.asansonne.management.ccsr.repository;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.management.enumeration.character.RealmName;
import it.asansonne.management.model.Realm;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RealmRepository extends GetRepository<Realm> {
  Optional<Realm> findByUuid(UUID uuid);

  @Query(value = "SELECT * FROM realms WHERE realm_name = CAST(:realm AS realm_name_enum)", nativeQuery = true)
  Optional<Realm> findByRealmName(@Param("realm") String realm);

  default Optional<Realm> findByRealmName(RealmName realmName) {
    return findByRealmName(realmName == null ? null : realmName.getName());
  }

}
