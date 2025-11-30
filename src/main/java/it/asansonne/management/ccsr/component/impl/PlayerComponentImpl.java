package it.asansonne.management.ccsr.component.impl;

import it.asansonne.management.ccsr.component.PlayerComponent;
import it.asansonne.management.dto.request.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerComponentImpl implements PlayerComponent {
  @Override
  public Page<PlayerResponse> findAll(Integer page, Integer size, String direction, Locale locale) {
    return null;
  }

  @Override
  public PlayerResponse findByUuid(UUID uuid) {
    return null;
  }

  @Override
  public Page<PlayerResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<PlayerResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return null;
  }

  @Override
  public Page<PlayerResponse> findAllByField(Integer page, Integer size, String direction,
                                             PlayerRequest request) {
    return null;
  }

  @Override
  public PlayerResponse findLastAdded() {
    return null;
  }

  @Override
  public void updateByUuid(UUID uuid, PlayerRequest request) {

  }

  @Override
  public PlayerResponse create(Principal principal, PlayerRequest request) {
    return null;
  }
//  private final PlayerService service;

}
