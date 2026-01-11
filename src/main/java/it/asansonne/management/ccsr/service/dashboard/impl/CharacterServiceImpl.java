package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.CharacterRepository;
import it.asansonne.management.ccsr.service.dashboard.CharacterService;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.model.Character;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterServiceImpl implements CharacterService {
  private final CharacterRepository characterRepository;

  @Override
  public Optional<Character> findByAbility(AbilityName ability) {
    return null;
  }

  @Override
  public Optional<Character> findByUuid(UUID uuid) {
    return Optional.empty();
  }

  @Override
  public Page<Character> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<Character> findAll(Pageable pageable, Locale locale) {
    return null;
  }

  @Override
  public Page<Character> findAllByField(Pageable pageable) {
    return null;
  }

  @Override
  public void update(Character model) {
    this.create(model);
  }

  @Override
  public Character create(Character model) {
    return characterRepository.save(model);
  }

}
