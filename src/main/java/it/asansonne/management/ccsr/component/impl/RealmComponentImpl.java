package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.ConflictException;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.management.ccsr.component.RealmComponent;
import it.asansonne.management.ccsr.component.RulesetComponent;
import it.asansonne.management.ccsr.service.dashboard.RealmService;
import it.asansonne.management.dto.request.RealmRequest;
import it.asansonne.management.dto.response.RealmResponse;
import it.asansonne.management.mapper.impl.RealmMapper;
import it.asansonne.management.model.Realm;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RealmComponentImpl implements RealmComponent {
  private final RealmService service;
  private final RealmMapper mapper;
  private final RulesetComponent rulesetComponent;

  @Override
  public RealmResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(
        this.service.findByUuid(uuid)
            .orElseThrow(() -> new NotFoundException("realm.not.found", uuid))
    );
  }

  @Override
  public Page<RealmResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<RealmResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, RealmRequest request) {
    this.service.update(this.mapper.toModel(request));
  }

  @Override
  public RealmResponse create(Principal principal, RealmRequest request) {
    log.info("request: {}", request);
    String name = request.getName();
    if (!name.toUpperCase().matches("^[A-Z0-9_]+$")) {
      throw new IllegalArgumentException("Invalid realm code");
    }
    if (this.service.findByName(name).isPresent()) {
      throw new ConflictException("Realm name already exists");
    }
    Realm realm = this.mapper.toModel(request);
    realm.setRuleset(rulesetComponent.getModel(request.getRulesetUuid()));
    return this.mapper.toDto(
        this.service.create(realm)
    );
  }

  @Override
  public RealmResponse findByName(String name) {
    return this.mapper.toDto(
        this.service.findByName(name)
            .orElseThrow(() -> new NotFoundException("realm.not.found"))
    );
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.service.deleteByUuid(uuid);
  }

}
