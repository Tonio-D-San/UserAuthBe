package it.asansonne.management.ccsr.component.impl;

import it.asansonne.management.ccsr.component.CardComponent;
import it.asansonne.management.ccsr.service.dashboard.CardService;
import it.asansonne.management.dto.request.CardRequest;
import it.asansonne.management.dto.response.CardResponse;
import it.asansonne.management.mapper.impl.CardMapper;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CardComponentImpl implements CardComponent {
  private final CardMapper mapper;
  private final CardService service;

  @Override
  public CardResponse findByUuid(UUID uuid) {
    return mapper.toDto(
        service.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Card not found"))
    );
  }

  @Override
  public Page<CardResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<CardResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return null;
  }

  @Override
  public Page<CardResponse> findAllByField(Pageable pageable, CardRequest request) {
    return null;
  }

  @Override
  public void updateByUuid(UUID uuid, CardRequest request) {

  }

  @Override
  public CardResponse create(Principal principal, CardRequest request) {
    return null;
  }
}
