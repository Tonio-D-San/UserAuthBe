package it.asansonne.authhub.ccsr.controller;

import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

public interface LoginController {
  String login();

  /**
   * Create user response entity.
   *
   * @param userRequest the person request
   * @param builder         the builder
   * @return the response entity
   */

  @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  ResponseEntity<UserResponse> createPerson(UserRequest userRequest, UriComponentsBuilder builder);
}
