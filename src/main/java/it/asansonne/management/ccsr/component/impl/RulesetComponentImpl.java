package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.ConflictException;
import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.management.ccsr.component.RulesetComponent;
import it.asansonne.management.ccsr.service.dashboard.RulesetService;
import it.asansonne.management.dto.request.RulesetRequest;
import it.asansonne.management.dto.response.RulesetResponse;
import it.asansonne.management.mapper.impl.RulesetMapper;
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
public class RulesetComponentImpl implements RulesetComponent {
  private final RulesetService service;
  private final RulesetMapper mapper;

  @Override
  public RulesetResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(
        this.service.findByUuid(uuid)
            .orElseThrow(() -> new NotFoundException("ruleset.not.found", uuid))
    );
  }

  @Override
  public Page<RulesetResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(this.service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<RulesetResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(this.service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<RulesetResponse> findAllByField(Pageable pageable, RulesetRequest request) {
    return this.mapper.toDto(this.service.findAllByField(pageable), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, RulesetRequest request) {
    if (request.getStatusRequest() == null) {
      this.service.update(this.mapper.toModel(request));
    } else {
      this.service.status(uuid, request.getStatusRequest().getStatus());
    }

  }

  @Override
  public RulesetResponse create(Principal principal, RulesetRequest request) {
    log.info("request: {}", request);
    String code = request.getCode();
    if (!code.toUpperCase().matches("^[A-Z0-9_]+$")) {
      throw new IllegalArgumentException("Invalid ruleset code");
    }
    if (this.service.findByCode(code).isPresent()) {
      throw new ConflictException("Ruleset code already exists");
    }
    return this.mapper.toDto(this.service.create(this.mapper.toModel(request)));
  }

  @Override
  public RulesetResponse findByCode(String code) {
    return this.mapper.toDto(
        this.service.findByCode(code.toUpperCase())
            .orElseThrow(() -> new NotFoundException("ruleset.not.found"))
    );
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.mapper.toDto(this.service.deleteByUuid(uuid));
  }

}
