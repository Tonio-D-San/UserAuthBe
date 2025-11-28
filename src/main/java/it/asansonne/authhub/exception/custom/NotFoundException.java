package it.asansonne.authhub.exception.custom;

import jakarta.persistence.PersistenceException;
import java.util.UUID;
import lombok.Getter;

/**
 * The type Not found exception.
 */
@Getter
public class NotFoundException extends PersistenceException {

  private final UUID[] args;

  public NotFoundException(String messageKey, UUID... args) {
    super(messageKey);
    this.args = args;
  }
}