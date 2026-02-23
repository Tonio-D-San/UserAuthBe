package it.asansonne.blog.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import it.asansonne.blog.ccsr.component.BlogPostComponent;
import it.asansonne.blog.ccsr.controller.BlogPostController;
import it.asansonne.blog.dto.request.BlogPostRequest;
import it.asansonne.blog.dto.response.BlogPostResponse;
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
@RequestMapping(API + "/" + AUTH_HUB_API_VERSION + "/blog-post")
@AllArgsConstructor
public class BlogPostControllerImpl implements BlogPostController {

  private final BlogPostComponent component;

  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public BlogPostResponse findByUuid(@PathVariable UUID uuid) {
    return this.component.findByUuid(uuid);
  }

  @Override
  public Page<BlogPostResponse> findByIsActive(
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
  public Page<BlogPostResponse> findAll(
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
      @PathVariable UUID uuid, @RequestBody BlogPostRequest request
  ) {
    component.updateByUuid(uuid, request);
  }

  @Override
  public ResponseEntity<BlogPostResponse> create(
      Principal principal,
      @Valid @RequestBody BlogPostRequest request,
      UriComponentsBuilder builder
  ) {
    BlogPostResponse response = component.create(principal, request);
    return ResponseEntity
        .created(builder
            .path(API + "/" + AUTH_HUB_API_VERSION + "/blog-post/create")
            .buildAndExpand(String.valueOf(response.getUuid()))
            .toUri()
        ).body(response);
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    component.deleteByUuid(uuid);
  }

  @Override
  public BlogPostResponse findBySlug(String slug) {
    return component.findBySlug(slug);
  }

  @Override
  public boolean existsBySlug(String slug) {
    return component.existsBySlug(slug);
  }

  @Override
  public Page<BlogPostResponse> findBySlugIn(
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
  public BlogPostResponse findBySlugAndStatus(String slug, String status) {
    return this.component.findBySlugAndStatus(slug, status);
  }

  @Override
  public Page<BlogPostResponse> findByStatusOrderByPublishedAtDesc(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      String status
  ) {
    return this.component.findByStatusOrderByPublishedAtDesc(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        status);
  }

  @Override
  public BlogPostResponse findWithTagsBySlugAndStatus(String slug, String status) {
    return this.component.findWithTagsBySlugAndStatus(slug, status);
  }

  @Override
  public Page<BlogPostResponse> findPublishedWithTags(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      String status) {
    return this.component.findPublishedWithTags(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        status
    );
  }

  @Override
  public Page<BlogPostResponse> findByStatusAndTagSlug(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      String tagSlug, String status
  ) {
    return this.component.findByStatusAndTagSlug(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        tagSlug, status
    );
  }

  @Override
  public Page<BlogPostResponse> searchPublished(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      String status, String q
  ) {
    return this.component.searchPublished(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        status, q
    );
  }
}
