package it.asansonne.authhub.security.provider;

import it.asansonne.authhub.ccsr.repository.users.UserRepository;
import it.asansonne.authhub.ccsr.service.users.impl.UserServiceImpl;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.model.users.User;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserProvisioningService {
  private final UserRepository userRepository;
  private final UserServiceImpl userService;

  public User upsertUser(String provider, String providerId, UserRequest userRequest) {
    var userOpt = userRepository.findByEmail(userRequest.getEmail());
    if (userOpt.isEmpty()) {
      User created = userService.create(
          User.builder()
              .provider(provider)
              .providerId(providerId)
              .email(userRequest.getEmail())
              .name(userRequest.getFirstname())
              .surname(userRequest.getLastname())
              .biography(userRequest.getBiography())
              .profileImage(userRequest.getProfileImage())
              .build()
      );
      log.info("Creato nuovo utente {} dal provider {}", userRequest.getEmail(), provider);
      return created;
    }

    User existing = userOpt.get();
    boolean updated = false;

    if (isDifferent(existing.getProvider(), provider)) {
      existing.setProvider(provider);
      updated = true;
    }
    if (isDifferent(existing.getProviderId(), providerId)) {
      existing.setProviderId(providerId);
      updated = true;
    }
    if (isDifferent(existing.getName(), userRequest.getFirstname())) {
      existing.setName(userRequest.getFirstname());
      updated = true;
    }
    if (isDifferent(existing.getSurname(), userRequest.getLastname())) {
      existing.setSurname(userRequest.getLastname());
      updated = true;
    }
    if (isDifferent(existing.getBiography(), userRequest.getBiography())) {
      existing.setBiography(userRequest.getBiography());
      updated = true;
    }
    if (!Arrays.equals(existing.getProfileImage(), userRequest.getProfileImage())) {
      existing.setProfileImage(userRequest.getProfileImage());
      updated = true;
    }

    if (updated) {
      User saved = userRepository.save(existing);
      log.info("Aggiornato utente {} con dati sincronizzati dal provider {}",
          userRequest.getEmail(), provider);
      return saved;
    }

    return existing;
  }

  private boolean isDifferent(String current, String incoming) {
    return incoming != null && !incoming.equals(current);
  }
}
