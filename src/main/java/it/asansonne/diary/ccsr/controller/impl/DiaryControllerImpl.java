package it.asansonne.diary.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.diary.ccsr.component.DiaryComponent;
import it.asansonne.diary.ccsr.controller.DiaryController;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.diary.dto.response.DiaryResponse;
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
@RequestMapping(API + "/" + API_VERSION + "/diary")
@AllArgsConstructor
public class DiaryControllerImpl implements DiaryController {

  private final DiaryComponent component;

  @GetMapping(value = "/{ability}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public DiaryResponse findDiaryByAbility(@PathVariable AbilityName ability) {
    return this.component.findByAbility(ability);
  }

  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public DiaryResponse findByUuid(@PathVariable("uuid") UUID uuid) {
    return this.component.findByUuid(uuid);
  }

  @Override
  public Page<DiaryResponse> findByIsActive(
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
  public Page<DiaryResponse> findAll(
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

  @Override
  public Page<DiaryResponse> findAllByField(Integer page, Integer size, String direction,
                                            DiaryRequest request) {
    return this.component.findAllByField(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
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
      @PathVariable("uuid") UUID uuid, DiaryRequest request
  ) {
    component.updateByUuid(uuid, request);
  }

  @Override
  public ResponseEntity<DiaryResponse> create(
      Principal principal,
      @Valid @RequestBody DiaryRequest request,
      UriComponentsBuilder builder
  ) {
    DiaryResponse response = component.create(principal, request);
    return ResponseEntity
        .created(builder
            .path(API + "/" + API_VERSION + "/diary")
            .buildAndExpand(String.valueOf(response.getUuid()))
            .toUri()
        ).body(response);
  }

}
