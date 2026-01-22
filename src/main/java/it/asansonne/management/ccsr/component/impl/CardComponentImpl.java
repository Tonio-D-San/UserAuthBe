package it.asansonne.management.ccsr.component.impl;

import it.asansonne.management.ccsr.component.CardComponent;
import it.asansonne.management.dto.request.CardRequest;
import it.asansonne.management.dto.response.CardResponse;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CardComponentImpl implements CardComponent {
  @Override
  public CardResponse findByUuid(UUID uuid) {
    return null;
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
