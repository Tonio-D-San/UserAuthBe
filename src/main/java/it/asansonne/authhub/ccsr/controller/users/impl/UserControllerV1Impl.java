package it.asansonne.authhub.ccsr.controller.users.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.authhub.ccsr.component.users.UserComponent;
import it.asansonne.authhub.ccsr.controller.users.UserControllerV1;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import jakarta.validation.Valid;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping(API + "/" + API_VERSION + "/users")
@AllArgsConstructor
@Tag(name = "UserController" + API_VERSION)
public class UserControllerV1Impl implements UserControllerV1 {

  private final UserComponent component;

  @Override
  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserResponse findByUuid(@PathVariable("uuid") UUID uuid) {
    return this.component.findByUuid(uuid);
  }

  @Override
  public Page<UserResponse> findByIsActive(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      @RequestParam(value = "isActive", defaultValue = "true") Boolean isActive
  ) {
    return this.component.findByIsActive(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), SURNAME)),
        isActive
    );
  }

  @Override
  public Page<UserResponse> findAll(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      Locale locale, Principal principal
  ) {
    return this.component.findAll(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), SURNAME)),
        locale, principal
    );
  }

  @Override
  public Page<UserResponse> findAllByField(Integer page, Integer size, String direction,
                                           UserRequest request) {
    return this.component.findAllByField(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), SURNAME)),
        request
    );
  }

  @Override
  public UserResponse findLastAdded() {
    return this.component.findLastAdded();
  }

  @Override
  public ResponseEntity<UserResponse> create(
      Principal principal,
      @Valid @RequestBody UserRequest personRequest,
      UriComponentsBuilder builder
  ) {
    UserResponse response = component.create(principal, personRequest);
    return ResponseEntity
        .created(builder
            .path(API + "/" + API_VERSION + "/admin/")
            .buildAndExpand(String.valueOf(response.getUuid()))
            .toUri()
        ).body(response);
  }

  @PatchMapping(
      value = "/status/{uuid}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @Override
  public void updateByUuid(
      @PathVariable("uuid") UUID uuid, UserRequest request
  ) {
    component.updateByUuid(uuid, request);
  }

}
