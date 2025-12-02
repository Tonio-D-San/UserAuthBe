package it.asansonne.authhub.ccsr.repository.users;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.authhub.model.users.Group;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;


/**
 * The interface Group repository.
 */
@Repository
public interface GroupRepository  extends
    GetRepository<Group>
{
  /**
   * Find a group by uuid optional.
   *
   * @param groupUuid the group uuid
   * @return the optional
   */
  Optional<Group> findGroupByUuid(UUID groupUuid);

  Optional<Group> findByPathContainingIgnoreCase(String path);
  List<Group> findAllByUuidIn(List<UUID> uuidList);

//  Optional<Group> findByUsersAndName(List<User> users, String name);
}
