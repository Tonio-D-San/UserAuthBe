package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.RealmRepository;
import it.asansonne.management.ccsr.service.dashboard.RealmService;
import it.asansonne.management.model.Realm;
import jakarta.persistence.EntityNotFoundException;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RealmServiceImpl implements RealmService {
  public static final String NOT_FOUND = "realm.not.found";
  private final RealmRepository repository;

  @Override
  public Optional<Realm> findByUuid(UUID uuid) {
    return this.repository.findByUuid(uuid);
  }

  @Override
  public Page<Realm> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<Realm> realms = this.repository.findAllByIsActive(isActive, pageable);
    if (realms.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "realms.active.empty" : "realms.inactive.empty"
      );
    }
    return realms;
  }

  @Override
  public Page<Realm> findAll(Pageable pageable, Locale locale) {
    Page<Realm> abilities = this.repository.findAll(pageable);
    if (abilities.isEmpty()) {
      throw new EntityNotFoundException("abilities.empty");
    }
    return abilities;
  }

  @Override
  public Page<Realm> findAllByField(Pageable pageable) {
    return this.repository.findAll(pageable);
  }

  @Override
  public void update(Realm model) {
    this.create(findRealm(model.getUuid()));
  }

  @Override
  public Realm create(Realm model) {
    return this.repository.save(model);
  }

  @Override
  public Optional<Realm> findByName(String name) {
    return this.repository.findByName(name);
  }

  @Override
  public Realm deleteByUuid(UUID uuid) {
    Realm realm = findRealm(uuid);
    this.repository.delete(realm);
    return realm;
  }

  private Realm findRealm(UUID uuid) {
    return this.findByUuid(uuid)
        .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
  }

}
