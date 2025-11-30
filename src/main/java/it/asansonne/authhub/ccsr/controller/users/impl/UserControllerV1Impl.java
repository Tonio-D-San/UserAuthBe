package it.asansonne.authhub.ccsr.controller.users.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;
import static it.asansonne.authhub.constant.SharedConstant.DEVELOP_ROLES;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * The type User controller.
 */
@Slf4j
@RestController
@RequestMapping(API + "/" + API_VERSION + "/users")
@AllArgsConstructor
@Tag(name = "UserController" + API_VERSION)
@PreAuthorize(DEVELOP_ROLES)
public class UserControllerV1Impl implements UserControllerV1 {
  private final UserComponent userComponent;

  @Override
  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserResponse findByUuid(@PathVariable("uuid") UUID uuid) {
    return userComponent.findByUuid(uuid);
  }

  @Override
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Page<UserResponse> findAll(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      Locale locale, Principal principal
  ) {
    return userComponent.findAll(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), SURNAME)),
        locale, principal
    );
  }

  @Override
  public Page<UserResponse> findAllByField(Integer page, Integer size, String direction,
                                           UserRequest request) {
    return null;
  }

  @Override
  public UserResponse findLastAdded() {
    return null;
  }

  @Override
  @GetMapping(value = "/isActive", produces = MediaType.APPLICATION_JSON_VALUE)
  public Page<UserResponse> findByIsActive(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      @RequestParam(value = "isActive", defaultValue = "true") Boolean isActive
  ) {
    return userComponent.findByIsActive(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), SURNAME)),
        isActive
    );
  }

  @Override
  @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserResponse> create(
      Principal principal,
      @Valid @RequestBody UserRequest personRequest,
      UriComponentsBuilder builder
  ) {
    UserResponse response = userComponent.create(principal, personRequest);
    return ResponseEntity
        .created(builder
            .path("ala/v1/admin/")
            .buildAndExpand(String.valueOf(response.getUuid()))
            .toUri()
        ).body(response);
  }

  @PatchMapping(value = "/status/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public void updateByUuid(
      @PathVariable("uuid") UUID uuid, UserRequest request
  ) {
    userComponent.updateByUuid(uuid, request);
  }

}
