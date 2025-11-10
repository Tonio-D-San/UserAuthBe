package it.asansonne.authhub.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.ADMIN_ROLES;
import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;
import static it.asansonne.authhub.constant.SharedConstant.DEVELOP_ROLES;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.authhub.ccsr.component.UserComponent;
import it.asansonne.authhub.ccsr.controller.UserControllerMappingV1;
import it.asansonne.authhub.dto.request.StatusRequest;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import jakarta.validation.Valid;
import java.security.Principal;
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
public class UserControllerV1Impl implements UserControllerMappingV1 {
  private final UserComponent userComponent;

  @Override
  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserResponse findUserByUuid(@PathVariable("uuid") UUID uuid) {
    return userComponent.findUserByUuid(uuid);
  }

  @Override
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Page<UserResponse> findAllUsers(Principal principal,
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction
  ) {
    return userComponent.findAllUsers(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), SURNAME))
    );
  }

  @Override
  @GetMapping(value = "/isActive", produces = MediaType.APPLICATION_JSON_VALUE)
  public Page<UserResponse> findUsersByIsActive(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      @RequestParam(value = "isActive", defaultValue = "true") Boolean isActive
  ) {
    return userComponent.findActiveUsers(
        isActive,
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), SURNAME))
    );
  }

  @Override
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

  @Override
  @PatchMapping(value = "/status/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateStatusUserByUuid(
      @PathVariable("uuid") UUID uuid, @RequestBody StatusRequest status
  ) {
    userComponent.updateStatusUserByUuid(uuid, status);
  }
}
