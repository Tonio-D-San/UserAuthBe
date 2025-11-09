package it.asansonne.authhub.ccsr.controller.impl;

import it.asansonne.authhub.ccsr.component.UserComponent;
import it.asansonne.authhub.ccsr.controller.LoginController;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

  private final UserComponent userComponent;

  @Override
  @CrossOrigin(origins = "http://localhost:5173")
  @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserResponse> createPerson(
      @Valid @RequestBody UserRequest personRequest,
      UriComponentsBuilder builder
  ) {
    UserResponse response = userComponent.createPerson(personRequest);
    return ResponseEntity
        .created(builder
            .path("api/v2/admin/")
            .buildAndExpand(response.getUuid().toString())
            .toUri()
        ).body(response);
  }
}

