package it.asansonne.authhub.exception.custom;

/**
 * The type Inactive user exception.
 */
public class ConflictException extends RuntimeException {

  /**
   * Instantiates a new Inactive user exception.
   */
  @SuppressWarnings("unused")
  public ConflictException() {
    super();
  }

  /**
   * Instantiates a new Inactive user exception.
   *
   * @param message the message
   */
  public ConflictException(String message) {
    super(message);
  }
}
