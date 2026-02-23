package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.AlchemyPathRepository;
import it.asansonne.management.ccsr.service.dashboard.AlchemyPathService;
import it.asansonne.management.model.AlchemyPath;
import jakarta.persistence.EntityNotFoundException;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlchemyPathServiceImpl implements AlchemyPathService {
  public static final String NOT_FOUND = "alchemyPath.not.found";
  private final AlchemyPathRepository repository;

  @Override
  public Optional<AlchemyPath> findByUuid(UUID uuid) {
            return this.repository.findByUuid(uuid);
  }

  @Override
  public Page<AlchemyPath> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<AlchemyPath> alchemyPaths = this.repository.findAllByIsActive(isActive, pageable);
    if (alchemyPaths.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "alchemyPaths.active.empty" : "alchemyPaths.inactive.empty"
      );
    }
    return alchemyPaths;
  }

  @Override
  public Page<AlchemyPath> findAll(Pageable pageable, Locale locale) {
    Page<AlchemyPath> abilities = this.repository.findAll(pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException("abilities.empty");
    }
    return abilities;
  }

  @Override
  public void update(AlchemyPath model) {
    this.create(findAlchemyPath(model.getUuid()));
  }

  public AlchemyPath update(AlchemyPath model, Consumer<AlchemyPath> mutator) {
    AlchemyPath alchemyPath = findAlchemyPath(model.getUuid());
    mutator.accept(alchemyPath);
    return repository.save(alchemyPath);
  }

  @Override
  public AlchemyPath create(AlchemyPath model) {
    return this.repository.save(model);
  }

  @Override
  public Optional<AlchemyPath> findByName(String name) {
    return this.repository.findByName(name);
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    AlchemyPath alchemyPath = findAlchemyPath(uuid);
    this.repository.delete(alchemyPath);
  }

  private AlchemyPath findAlchemyPath(UUID uuid) {
    return this.findByUuid(uuid)
        .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
  }

}
