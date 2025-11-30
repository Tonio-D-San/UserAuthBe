package it.asansonne.authhub.ccsr.service;

import it.asansonne.authhub.model.Models;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetService<M extends Models> {

  Optional<M> findByUuid(UUID uuid);

  Page<M> findByIsActive(
      Pageable pageable,
      Boolean isActive
  );

  Page<M> findAll(
      Pageable pageable, Locale locale
  );

  Page<M> findAllByField(
      Pageable pageable
//      R request
  );

  Optional<M> findLastAdded();
}
