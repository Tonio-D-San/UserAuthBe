package it.asansonne.authhub.exception.custom;

/**
 * The type Parent creation date exception.
 */
public class IOCustomException extends RuntimeException {

  /**
   * Instantiates a new Parent creation date exception.
   */
  @SuppressWarnings("unused")
  public IOCustomException() {
    super();
  }

  /**
   * Instantiates a new Parent creation date exception.
   *
   * @param messageKey the messageKey
   */
  public IOCustomException(String messageKey) {
    super(messageKey);
  }
}
