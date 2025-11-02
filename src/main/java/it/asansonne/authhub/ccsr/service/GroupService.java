package it.asansonne.authhub.ccsr.service;

import it.asansonne.authhub.model.Group;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The type Group service.
 */
public interface GroupService {

  /**
   * Find a group by uuid optional.
   *
   * @param uuid the uuid
   * @return the optional
   */
  Optional<Group> findGroupByUuid(UUID uuid);

  List<Group> findAllByUuidIn(List<UUID> uuidList);
}
