package it.asansonne.management.ccsr.component.impl;

import it.asansonne.management.ccsr.component.BagComponent;
import it.asansonne.management.ccsr.service.dashboard.BagService;
import it.asansonne.management.dto.request.BagRequest;
import it.asansonne.management.dto.response.BagResponse;
import it.asansonne.management.mapper.impl.BagMapper;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BagComponentImpl implements BagComponent {
  private final BagService service;
  private final BagMapper bagMapper;

  @Override
  public BagResponse findByUuid(UUID uuid) {
    return bagMapper.toDto(
        service.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Bag not found"))
    );
  }

  @Override
  public Page<BagResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return bagMapper.toDto(
        service.findByIsActive(pageable, isActive), pageable
    );
  }

  @Override
  public Page<BagResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return bagMapper.toDto(service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<BagResponse> findAllByField(Pageable pageable, BagRequest request) {
    return bagMapper.toDto(service.findAllByField(pageable), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, BagRequest request) {
    service.update(bagMapper.toModel(request));
  }

  @Override
  public BagResponse create(Principal principal, BagRequest request) {
    return null;
  }
}
