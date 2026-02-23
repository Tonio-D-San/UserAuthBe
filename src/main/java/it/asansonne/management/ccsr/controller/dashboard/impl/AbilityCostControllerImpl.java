package it.asansonne.management.ccsr.controller.dashboard.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import it.asansonne.management.ccsr.component.AbilityCostComponent;
import it.asansonne.management.ccsr.controller.dashboard.AbilityCostController;
import it.asansonne.management.dto.request.AbilityCostRequest;
import it.asansonne.management.dto.response.AbilityCostResponse;
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
@RequestMapping(API + "/" + AUTH_HUB_API_VERSION + "/abilities/cost")
@AllArgsConstructor
public class AbilityCostControllerImpl implements AbilityCostController {

  private final AbilityCostComponent component;

  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public AbilityCostResponse findByUuid(@PathVariable UUID uuid) {
    return this.component.findByUuid(uuid);
  }

  @Override
  public Page<AbilityCostResponse> findByIsActive(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      @RequestParam(value = "isActive", defaultValue = "true") Boolean isActive
  ) {
    return this.component.findByIsActive(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        isActive
    );
  }

  @Override
  public Page<AbilityCostResponse> findAll(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      Locale locale, Principal principal
  ) {
    return this.component.findAll(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        locale, principal
    );
  }

  @PatchMapping(
      value = "/{uuid}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @Override
  public void updateByUuid(
      @PathVariable UUID uuid, @RequestBody AbilityCostRequest request
  ) {
    component.updateByUuid(uuid, request);
  }

  @Override
  public ResponseEntity<AbilityCostResponse> create(
      Principal principal,
      @Valid @RequestBody AbilityCostRequest request,
      UriComponentsBuilder builder
  ) {
    AbilityCostResponse response = component.create(principal, request);
    return ResponseEntity
        .created(builder
            .path(API + "/" + AUTH_HUB_API_VERSION + "/abilities/cost/{uuid}")
            .buildAndExpand(String.valueOf(response.getUuid()))
            .toUri()
        ).body(response);
  }

}
