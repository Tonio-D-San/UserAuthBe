package it.asansonne.blog.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import it.asansonne.blog.ccsr.component.BlogTagComponent;
import it.asansonne.blog.ccsr.controller.BlogTagController;
import it.asansonne.blog.dto.request.BlogTagRequest;
import it.asansonne.blog.dto.response.BlogTagResponse;
import jakarta.validation.Valid;
import java.security.Principal;
import java.util.List;
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
@RequestMapping(API + "/" + AUTH_HUB_API_VERSION + "/blog-tag")
@AllArgsConstructor
public class BlogTagControllerImpl implements BlogTagController {

  private final BlogTagComponent component;

  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public BlogTagResponse findByUuid(@PathVariable UUID uuid) {
    return this.component.findByUuid(uuid);
  }

  @Override
  public Page<BlogTagResponse> findByIsActive(
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
  public Page<BlogTagResponse> findAll(
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
      @PathVariable UUID uuid, @RequestBody BlogTagRequest request
  ) {
    component.updateByUuid(uuid, request);
  }

  @Override
  public ResponseEntity<BlogTagResponse> create(
      Principal principal,
      @Valid @RequestBody BlogTagRequest request,
      UriComponentsBuilder builder
  ) {
    BlogTagResponse response = component.create(principal, request);
    return ResponseEntity
        .created(builder
            .path(API + "/" + AUTH_HUB_API_VERSION + "/blog-tag/")
            .buildAndExpand(String.valueOf(response.getUuid()))
            .toUri()
        ).body(response);
  }

  @Override
  public BlogTagResponse findBySlug(String slug) {
    return component.findBySlug(slug);
  }

  @Override
  public BlogTagResponse findByNameIgnoreCase(String name) {
    return component.findByNameIgnoreCase(name);
  }

  @Override
  public Page<BlogTagResponse> findByUuidIn(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      List<UUID> uuids
  ) {
    return this.component.findByUuidIn(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        uuids);
  }

  @Override
  public boolean existsBySlug(String slug) {
    return component.existsBySlug(slug);
  }

  @Override
  public Page<BlogTagResponse> findBySlugIn(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      List<String> slugs
  ) {
    return component.findBySlugIn(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        slugs
    );
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.component.deleteByUuid(uuid);
  }
}
