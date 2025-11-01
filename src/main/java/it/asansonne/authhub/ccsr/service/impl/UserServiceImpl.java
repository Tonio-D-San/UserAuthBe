package it.asansonne.authhub.ccsr.service.impl;

import it.asansonne.authhub.ccsr.repository.jpa.GroupRepository;
import it.asansonne.authhub.ccsr.repository.jpa.UserRepository;
import it.asansonne.authhub.ccsr.service.UserService;
import it.asansonne.authhub.model.jpa.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
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
  public Optional<User> findUserByUuid(UUID userUuid) {
    return userRepository.findUserByUuid(userUuid);
  }

  @Override
  public Page<User> findAllUsers(Pageable pageable) {
    Page<User> users = userRepository.findAll(pageable);
    if (users.isEmpty()) {
      throw new EntityNotFoundException("person.empty");
    }
    return users;
  }

  @Override
  public Page<User> findActiveUsers(Boolean isActive, Pageable pageable) {
    Page<User> users = userRepository.findAllByIsActive(isActive, pageable);
    if (users.isEmpty()) {
      throw new EntityNotFoundException("person.active.empty");
    }
    return users;
  }

  @Override
  public Page<User> findInactiveUsers(Pageable pageable) {
    Page<User> users = userRepository.findAllByIsActiveFalse(pageable);
    if (users.isEmpty()) {
      throw new EntityNotFoundException("person.inactive.empty");
    }
    return users;
  }

  @Override
  public User createUser(User user) {
    user.setGroups(
        List.of(Objects.requireNonNull(groupRepository.findById(3).orElse(null)))
    );
    return userRepository.save(user);
  }

  @Override
  public void updateUser(User user) {
    userRepository.save(user);
  }
}
