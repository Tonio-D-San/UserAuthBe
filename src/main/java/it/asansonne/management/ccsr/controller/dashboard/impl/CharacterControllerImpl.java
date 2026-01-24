package it.asansonne.management.ccsr.controller.dashboard.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.management.ccsr.component.CharacterComponent;
import it.asansonne.management.ccsr.controller.dashboard.CharacterController;
import it.asansonne.management.dto.request.CharacterRequest;
import it.asansonne.management.dto.response.CharacterResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import jakarta.validation.Valid;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
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

@RestController
@RequestMapping(API + "/" + API_VERSION + "/characters")
@AllArgsConstructor
public class CharacterControllerImpl implements CharacterController {

  private final CharacterComponent component;

  @GetMapping(value = "/abilities/{ability}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public CharacterResponse findByAbility(@PathVariable AbilityName ability) {
    return this.component.findByAbility(ability);
  }

  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public CharacterResponse findByUuid(@PathVariable("uuid") UUID uuid) {
    return this.component.findByUuid(uuid);
  }

  @Override
  public Page<CharacterResponse> findByIsActive(
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
  public Page<CharacterResponse> findAll(
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
  public Page<CharacterResponse> findAllByField(Integer page, Integer size, String direction,
                                             CharacterRequest request) {
    return this.component.findAllByField(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), SURNAME)),
        request
    );
  }

  @PatchMapping(
      value = "/{uuid}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @Override
  public void updateByUuid(
      @PathVariable UUID uuid, CharacterRequest request
  ) {
    component.updateByUuid(uuid, request);
  }

  @Override
  public ResponseEntity<CharacterResponse> create(
      Principal principal,
      @Valid @RequestBody CharacterRequest request,
      UriComponentsBuilder builder
  ) {
    CharacterResponse response = component.create(principal, request);
    return ResponseEntity
        .created(builder
            .path(API + "/" + API_VERSION + "/characters/{uuid}")
            .buildAndExpand(String.valueOf(response.getUuid()))
            .toUri()
        ).body(response);
  }

}
