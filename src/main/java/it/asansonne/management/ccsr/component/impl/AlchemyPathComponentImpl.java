package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.ConflictException;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.management.ccsr.component.AlchemyPathComponent;
import it.asansonne.management.ccsr.component.RulesetComponent;
import it.asansonne.management.ccsr.service.dashboard.AlchemyPathService;
import it.asansonne.management.dto.request.AlchemyPathRequest;
import it.asansonne.management.dto.response.AlchemyPathResponse;
import it.asansonne.management.mapper.impl.AlchemyPathMapper;
import it.asansonne.management.model.AlchemyPath;
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
public class AlchemyPathComponentImpl implements AlchemyPathComponent {
  private final AlchemyPathService service;
  private final AlchemyPathMapper mapper;
  private final RulesetComponent rulesetComponent;

  @Override
  public AlchemyPathResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(
        this.service.findByUuid(uuid)
            .orElseThrow(() -> new NotFoundException("alchemyPath.not.found", uuid))
    );
  }

  @Override
  public Page<AlchemyPathResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<AlchemyPathResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<AlchemyPathResponse> findAllByField(Pageable pageable, AlchemyPathRequest request) {
    return this.mapper.toDto(this.service.findAllByField(pageable), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, AlchemyPathRequest request) {
    this.service.update(this.mapper.toModel(request));
  }

  @Override
  public AlchemyPathResponse create(Principal principal, AlchemyPathRequest request) {
    log.info("request: {}", request);
    String name = request.getName();
    if (!name.toUpperCase().matches("^[A-Z0-9_]+$")) {
      throw new IllegalArgumentException("Invalid alchemyPath code");
    }
    if (this.service.findByName(name).isPresent()) {
      throw new ConflictException("AlchemyPath name already exists");
    }
    AlchemyPath alchemyPath = this.mapper.toModel(request);
    alchemyPath.setRuleset(rulesetComponent.getModel(request.getRulesetUuid()));
    return this.mapper.toDto(
        this.service.create(alchemyPath)
    );
  }

  @Override
  public AlchemyPathResponse findByName(String name) {
    return this.mapper.toDto(
        this.service.findByName(name)
            .orElseThrow(() -> new NotFoundException("alchemyPath.not.found"))
    );
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.service.deleteByUuid(uuid);
  }

}
