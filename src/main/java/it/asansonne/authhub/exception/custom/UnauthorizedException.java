package it.asansonne.authhub.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

/**
 * The type Inactive person exception.
 */
public class UnauthorizedException extends HttpClientErrorException {

  /**
   * Instantiates a new Inactive person exception.
   *
   * @param message the message
   */
  public UnauthorizedException(String message) {
    super(HttpStatus.UNAUTHORIZED, message);
  }
}
