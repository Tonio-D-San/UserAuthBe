package it.asansonne.blog.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.blog.ccsr.component.BlogTagComponent;
import it.asansonne.blog.ccsr.service.BlogTagService;
import it.asansonne.blog.dto.request.BlogTagRequest;
import it.asansonne.blog.dto.response.BlogTagResponse;
import it.asansonne.blog.mapper.impl.BlogTagMapper;
import it.asansonne.blog.model.BlogTag;
import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BlogTagComponentImpl implements BlogTagComponent {

  private final BlogTagService service;
  private final BlogTagMapper mapper;

  @Override
  public BlogTagResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(findTag(uuid));
  }

  @Override
  public Page<BlogTagResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(
        this.service.findByIsActive(pageable, isActive), pageable
    );
  }

  @Override
  public Page<BlogTagResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(
        this.service.findAll(pageable, locale), pageable
    );
  }

  @Override
  public void updateByUuid(UUID uuid, BlogTagRequest request) {
    BlogTag tag = findTag(uuid);
    if (!tag.getName().equals(request.getName().trim())) {
      tag.setName(request.getName());
    }
    if (!tag.getSlug().equals(request.getSlug().toLowerCase().trim())) {
      tag.setSlug(request.getSlug().toLowerCase());
    }
    this.service.update(tag);
  }

  @Override
  public BlogTagResponse create(Principal principal, BlogTagRequest request) {
    return this.mapper.toDto(this.service.create(
        BlogTag.builder()
            .name(request.getName())
            .slug(request.getSlug().toLowerCase())
            .build()
    ));
  }

  @Override
  public BlogTagResponse findBySlug(String slug) {
    return this.mapper.toDto(
        this.service.findBySlug(slug)
            .orElseThrow(() -> new NotFoundException("slug.not.found"))
    );
  }

  @Override
  public BlogTagResponse findByNameIgnoreCase(String name) {
    return this.mapper.toDto(
        this.service.findByNameIgnoreCase(name)
            .orElseThrow(() -> new NotFoundException("name.not.found"))
    );
  }

  @Override
  public boolean existsBySlug(String slug) {
    return this.service.existsBySlug(slug);
  }

  @Override
  public Page<BlogTagResponse> findByUuidIn(Pageable pageable, List<UUID> uuids) {
    return this.mapper.toDto(this.service.findByUuidIn(uuids, pageable), pageable);
  }

  @Override
  public Page<BlogTagResponse> findBySlugIn(Pageable pageable, List<String> slugs) {
    return this.mapper.toDto(
        this.service.findBySlugIn(slugs, pageable), pageable
    );
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.service.deleteByUuid(uuid);
  }

  public BlogTag findTag(UUID uuid) {
    return this.service.findByUuid(uuid)
        .orElseThrow(() -> new NotFoundException("blogTag.not.found", uuid))
        ;
  }
}
