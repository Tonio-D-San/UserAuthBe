package it.asansonne.authhub.ccsr.repository;

import it.asansonne.authhub.model.BaseModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GetRepository<M extends BaseModel> extends JpaRepository<M, Long> {

  Optional<M> findByUuid(UUID uuid);

  Page<M> findAllByIsActive(Boolean isActive, Pageable pageable);

//  Page<M> findAllByField(Pageable pageable);

}
