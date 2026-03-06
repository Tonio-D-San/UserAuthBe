package it.asansonne.authhub.ccsr.service.impl;

import it.asansonne.authhub.ccsr.repository.GroupRepository;
import it.asansonne.authhub.ccsr.repository.UserRepository;
import it.asansonne.authhub.ccsr.service.UserService;
import it.asansonne.authhub.model.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Slf4j
@Service
@AllArgsConstructor
public final class UserServiceImpl implements UserService {
  private final UserRepository repository;
  private final GroupRepository groupRepository;

  @Override
  public Optional<User> findByUuid(UUID userUuid) {
    return this.repository.findByUuid(userUuid);
  }

  @Override
  public Page<User> findAll(Pageable pageable, Locale locale) {
    Page<User> users = this.repository.findAll(pageable);
    if (users.isEmpty()) {
      throw new EntityNotFoundException("person.empty");
    }
    return users;
  }

  @Override
  public Page<User> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<User> users = this.repository.findAllByIsActive(isActive, pageable);
    if (users.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "person.active.empty" : "person.inactive.empty"
      );
    }
    return users;
  }

  @Override
  public User create(User user) {
    log.info("user uuid: {}", user.getUuid());
    user.setGroups(
        List.of(Objects.requireNonNull(this.groupRepository.findById(3L).orElse(null)))
    );
    return this.repository.save(user);
  }

  @Override
  public void update(User user) {
    this.create(user);
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.repository.delete(
        this.findByUuid(uuid)
            .orElseThrow(() -> new EntityNotFoundException("person.not.found"))
    );
  }
}
