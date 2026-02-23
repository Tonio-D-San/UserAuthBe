package it.asansonne.blog.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.blog.ccsr.component.BlogPageComponent;
import it.asansonne.blog.ccsr.service.BlogPageService;
import it.asansonne.blog.ccsr.service.BlogTagService;
import it.asansonne.blog.dto.request.BlogPageRequest;
import it.asansonne.blog.dto.request.BlogTagRequest;
import it.asansonne.blog.dto.response.BlogPageResponse;
import it.asansonne.blog.mapper.impl.BlogPageMapper;
import it.asansonne.blog.model.BlogPage;
import it.asansonne.blog.model.BlogTag;
import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BlogPageComponentImpl implements BlogPageComponent {

  private final BlogPageService service;
  private final BlogPageMapper mapper;
  private final BlogTagService tagService;

  @Override
  public BlogPageResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(findPage(uuid));
  }

  @Override
  public Page<BlogPageResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(
        this.service.findByIsActive(pageable, isActive), pageable
    );
  }

  @Override
  public Page<BlogPageResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(
        this.service.findAll(pageable, locale), pageable
    );
  }

  @Override
  public void updateByUuid(UUID uuid, BlogPageRequest request) {
    BlogPage post = findPage(uuid);
    post.setIsActive(request.getStatusRequest().getIsActive());
    this.service.update(post);
  }

  @Override
  public BlogPageResponse create(Principal principal, BlogPageRequest request) {
    Pageable pageable = Pageable.unpaged();
    List<BlogTagRequest> tagRequests = request.getTags();
    return this.mapper.toDto(
        service.create(
            BlogPage.builder()
                .slug(request.getSlug())
                .title(request.getTitle())
                .contentMd(request.getContentMd())
                .status(request.getStatusRequest().getStatus().getName())
                .tags(findByUuidIn(pageable, tagRequests).isEmpty() ? tagRequests.stream()
                    .filter(Objects::nonNull)
                    .map(req -> BlogTag.builder()
                        .name(req.getName())
                        .slug(req.getSlug().toLowerCase())
                        .build()
                    ).map(tagService::create)
                    .toList() : findByUuidIn(pageable, tagRequests)).build()
        )
    );
  }

  @Override
  public BlogPageResponse findBySlug(String slug) {
    return this.mapper.toDto(
        this.service.findBySlug(slug)
            .orElseThrow(() -> new NotFoundException("blog.page.not.found"))
    );
  }

  @Override
  public boolean existsBySlug(String slug) {
    return false;
  }

  @Override
  public Page<BlogPageResponse> findBySlugIn(Pageable pageable, List<String> slugs) {
    return this.mapper.toDto(
        service.findBySlugIn(slugs, pageable), pageable
    );
  }

  @Override
  public BlogPageResponse findBySlugAndStatus(String slug, String status) {
    return this.mapper.toDto(
        this.service.findBySlugAndStatus(slug, status)
            .orElseThrow(() -> new NotFoundException("blog.page.status.not.found"))
    );
  }

  @Override
  public Page<BlogPageResponse> findByStatusOrderByPublishedAtDesc(
      Pageable pageable, String status
  ) {
    return this.mapper.toDto(
        this.service.findByStatusOrderByPublishedAtDesc(status, pageable), pageable
    );
  }

  @Override
  public BlogPageResponse findWithTagsBySlugAndStatus(String slug, String status) {
    return this.mapper.toDto(
        this.service.findWithTagsBySlugAndStatus(slug, status)
            .orElseThrow(() -> new NotFoundException("blog.page.not.found"))
    );
  }

  @Override
  public Page<BlogPageResponse> findPublishedWithTags(
      Pageable pageable, String status
  ) {
    return this.mapper.toDto(
        this.service.findPublishedWithTags(status, pageable),
        pageable
    );
  }

  @Override
  public Page<BlogPageResponse> findByStatusAndTagSlug(
      Pageable pageable, String status, String tagSlug
  ) {
    return this.mapper.toDto(
        this.service.findByStatusAndTagSlug(status, tagSlug, pageable), pageable
    );
  }

  @Override
  public Page<BlogPageResponse> searchPublished(Pageable pageable, String status, String q) {
    return null;
  }

  public BlogPage findPage(UUID uuid) {
    return this.service.findByUuid(uuid)
        .orElseThrow(() -> new NotFoundException("blogPost.not.found", uuid));
  }

  public List<BlogTag> findByUuidIn(Pageable pageable, List<BlogTagRequest> tagRequests) {
    return tagService.findByUuidIn(
        tagRequests.stream().map(BlogTagRequest::getUuid).toList(),
        pageable
    ).stream().toList();
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.service.deleteByUuid(uuid);
  }
}
