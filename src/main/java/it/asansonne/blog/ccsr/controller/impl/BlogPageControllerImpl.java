package it.asansonne.blog.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import it.asansonne.blog.ccsr.component.BlogPageComponent;
import it.asansonne.blog.ccsr.controller.BlogPageController;
import it.asansonne.blog.dto.request.BlogPageRequest;
import it.asansonne.blog.dto.response.BlogPageResponse;
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
@RequestMapping(API + "/" + AUTH_HUB_API_VERSION + "/blog-page")
@AllArgsConstructor
public class BlogPageControllerImpl implements BlogPageController {

  private final BlogPageComponent component;

  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public BlogPageResponse findByUuid(@PathVariable UUID uuid) {
    return this.component.findByUuid(uuid);
  }

  @Override
  public Page<BlogPageResponse> findByIsActive(
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
  public Page<BlogPageResponse> findAll(
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
      @PathVariable UUID uuid, @RequestBody BlogPageRequest request
  ) {
    component.updateByUuid(uuid, request);
  }

  @Override
  public ResponseEntity<BlogPageResponse> create(
      Principal principal,
      @Valid @RequestBody BlogPageRequest request,
      UriComponentsBuilder builder
  ) {
    BlogPageResponse response = component.create(principal, request);
    return ResponseEntity
        .created(builder
            .path(API + "/" + AUTH_HUB_API_VERSION + "/blog-page/create")
            .buildAndExpand(String.valueOf(response.getUuid()))
            .toUri()
        ).body(response);
  }

  @Override
  public BlogPageResponse findBySlug(String slug) {
    return this.component.findBySlug(slug);
  }

  @Override
  public boolean existsBySlug(String slug) {
    return this.component.existsBySlug(slug);
  }

  @Override
  public Page<BlogPageResponse> findBySlugIn(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      List<String> slugs
  ) {
    return this.component.findBySlugIn(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        slugs
    );
  }

  @Override
  public BlogPageResponse findBySlugAndStatus(String slug, String status) {
    return this.component.findBySlugAndStatus(slug, status);
  }

  @Override
  public Page<BlogPageResponse> findByStatusOrderByPublishedAtDesc(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      String status) {
    return this.component.findByStatusOrderByPublishedAtDesc(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        status
    );
  }

  @Override
  public BlogPageResponse findWithTagsBySlugAndStatus(String slug, String status) {
    return this.component.findWithTagsBySlugAndStatus(slug, status);
  }

  @Override
  public Page<BlogPageResponse> findPublishedWithTags(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      String status) {
    return component.findPublishedWithTags(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        status
    );
  }

  @Override
  public Page<BlogPageResponse> findByStatusAndTagSlug(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      String status,
      String tagSlug
  ) {
    return this.component.findByStatusAndTagSlug(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        status, tagSlug
    );
  }

  @Override
  public Page<BlogPageResponse> searchPublished(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      String status, String q
  ) {
    return component.searchPublished(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        status, q
    );
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.component.deleteByUuid(uuid);
  }
}
