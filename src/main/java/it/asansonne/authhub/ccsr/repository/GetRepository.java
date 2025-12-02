package it.asansonne.authhub.ccsr.repository;

import it.asansonne.authhub.model.Models;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetRepository<M extends Models> extends JpaRepository<M, Integer> {

  Optional<M> findByUuid(UUID uuid);

  Page<M> findAllByIsActive(Boolean isActive, Pageable pageable);

//  Page<M> findAllByField(Pageable pageable);

}
