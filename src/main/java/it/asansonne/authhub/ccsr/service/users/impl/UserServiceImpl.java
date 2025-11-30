package it.asansonne.authhub.ccsr.service.users.impl;

import it.asansonne.authhub.ccsr.repository.GroupRepository;
import it.asansonne.authhub.ccsr.repository.UserRepository;
import it.asansonne.authhub.ccsr.service.users.UserService;
import it.asansonne.authhub.model.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
@AllArgsConstructor
public final class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final GroupRepository groupRepository;

  @Override
  public Optional<User> findByUuid(UUID userUuid) {
    return userRepository.findUserByUuid(userUuid);
  }

  @Override
  public Page<User> findAll(Pageable pageable, Locale locale) {
    Page<User> users = userRepository.findAll(pageable);
    if (users.isEmpty()) {
      throw new EntityNotFoundException("person.empty");
    }
    return users;
  }

  @Override
  public Page<User> findAllByField(Pageable pageable) {
    return null;
  }

  @Override
  public Optional<User> findLastAdded() {
    return Optional.empty();
  }

  @Override
  public Page<User> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<User> users = userRepository.findAllByIsActive(isActive, pageable);
    if (users.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "person.active.empty" : "person.inactive.empty"
      );
    }
    return users;
  }

  @Override
  public User create(User user) {
    user.setGroups(
        List.of(Objects.requireNonNull(groupRepository.findById(3).orElse(null)))
    );
    return userRepository.save(user);
  }

  @Override
  public void update(User user) {
    userRepository.save(user);
  }

}
