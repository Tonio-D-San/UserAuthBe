package it.asansonne.authhub.ccsr.repository.jpa;

import it.asansonne.authhub.model.jpa.Group;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface Group repository.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
  /**
   * Find a group by uuid optional.
   *
   * @param groupUuid the group uuid
   * @return the optional
   */
  Optional<Group> findGroupByUuid(UUID groupUuid);

  Optional<Group> findByPathContainingIgnoreCase(String path);
  List<Group> findAllByUuidIn(List<UUID> uuidList);
}
