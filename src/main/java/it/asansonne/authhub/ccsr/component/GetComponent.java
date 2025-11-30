package it.asansonne.authhub.ccsr.component;

import it.asansonne.authhub.dto.Request;
import it.asansonne.authhub.dto.Response;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetComponent<R extends Request, S extends Response> {
  /**
   * The constant SURNAME.
   */
  String SURNAME = "surname";

  S findByUuid(UUID uuid);

  Page<S> findByIsActive(
      Pageable pageable,
      Boolean isActive
  );

  Page<S> findAll(
      Pageable pageable,
      Locale locale, Principal principal
  );

  Page<S> findAllByField(
      Integer page, Integer size, String direction,
      R request
  );

  S findLastAdded();
}
