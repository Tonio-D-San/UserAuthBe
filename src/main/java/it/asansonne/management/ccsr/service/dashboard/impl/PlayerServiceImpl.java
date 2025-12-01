package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.PlayerRepository;
import it.asansonne.management.ccsr.service.dashboard.PlayerService;
import it.asansonne.management.model.Player;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
  private final PlayerRepository playerRepository;
  @Override
  public Optional<Player> findByUuid(UUID uuid) {
    return Optional.empty();
  }

  @Override
  public Page<Player> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<Player> findAll(Pageable pageable, Locale locale) {
    return null;
  }

  @Override
  public Page<Player> findAllByField(Pageable pageable) {
    return null;
  }

  @Override
  public Optional<Player> findLastAdded() {
    return Optional.empty();
  }

  @Override
  public void update(Player model) {
    this.create(model);
  }

  @Override
  public Player create(Player model) {
    return playerRepository.save(model);
  }
}
