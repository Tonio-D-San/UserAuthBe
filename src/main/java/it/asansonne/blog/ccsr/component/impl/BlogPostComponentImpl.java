package it.asansonne.blog.ccsr.component.impl;

import it.asansonne.authhub.exception.custom.NotFoundException;
import it.asansonne.blog.ccsr.component.BlogPostComponent;
import it.asansonne.blog.ccsr.service.BlogPostService;
import it.asansonne.blog.ccsr.service.BlogTagService;
import it.asansonne.blog.dto.request.BlogPostRequest;
import it.asansonne.blog.dto.request.BlogTagRequest;
import it.asansonne.blog.dto.response.BlogPostResponse;
import it.asansonne.blog.mapper.impl.BlogPostMapper;
import it.asansonne.blog.model.BlogPost;
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
public class BlogPostComponentImpl implements BlogPostComponent {

  public static final String BLOG_POST_NOT_FOUND = "blogPost.not.found";
  private final BlogPostService service;
  private final BlogPostMapper mapper;
  private final BlogTagService tagService;

  @Override
  public BlogPostResponse findByUuid(UUID uuid) {
    return this.mapper.toDto(findPost(uuid));
  }

  @Override
  public Page<BlogPostResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return this.mapper.toDto(
        service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<BlogPostResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return this.mapper.toDto(
        this.service.findAll(pageable, locale), pageable
    );
  }

  @Override
  public void updateByUuid(UUID uuid, BlogPostRequest request) {
    BlogPost post = findPost(uuid);
    post.setIsActive(request.getStatusRequest().getIsActive());
    this.service.update(post);
  }

  @Override
  public BlogPostResponse create(Principal principal, BlogPostRequest request) {
    List<BlogTagRequest> tagRequests = request.getTags();
    Pageable pageable = Pageable.unpaged();
    return this.mapper.toDto(
        service.create(
            BlogPost.builder()
                .slug(request.getSlug())
                .title(request.getTitle())
                .excerpt(request.getExcerpt())
                .contentMd(request.getContentMd())
                .coverUrl(request.getCoverUrl())
                .authorName(request.getAuthorName())
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

  private List<BlogTag> findByUuidIn(Pageable pageable, List<BlogTagRequest> tagRequests) {
    return tagService.findByUuidIn(
        tagRequests.stream().map(BlogTagRequest::getUuid).toList(),
        pageable
    ).stream().toList();
  }

  @Override
  public BlogPostResponse findBySlugAndStatus(String slug, String status) {
    return this.mapper.toDto(
        this.service.findBySlugAndStatus(slug, status)
            .orElseThrow(() -> new NotFoundException(BLOG_POST_NOT_FOUND))
    );
  }

  @Override
  public Page<BlogPostResponse> findByStatusOrderByPublishedAtDesc(
      Pageable pageable, String status
  ) {
    return this.mapper.toDto(
        this.service.findByStatusOrderByPublishedAtDesc(status, pageable), pageable
    );
  }

  @Override
  public BlogPostResponse findWithTagsBySlugAndStatus(String slug, String status) {
    return this.mapper.toDto(
        this.service.findWithTagsBySlugAndStatus(slug, status)
            .orElseThrow(() -> new NotFoundException(BLOG_POST_NOT_FOUND))
    );
  }

  @Override
  public Page<BlogPostResponse> findPublishedWithTags(Pageable pageable, String status) {
    return this.mapper.toDto(
        this.service.findPublishedWithTags(status, pageable), pageable
    );
  }

  @Override
  public Page<BlogPostResponse> findByStatusAndTagSlug(
      Pageable pageable, String status, String tagSlug
  ) {
    return this.mapper.toDto(
        this.service.findByStatusAndTagSlug(status, tagSlug, pageable), pageable
    );
  }

  @Override
  public Page<BlogPostResponse> searchPublished(Pageable pageable, String status, String q) {
    return this.mapper.toDto(this.service.searchPublished(status, q, pageable), pageable);
  }

  @Override
  public BlogPostResponse findBySlug(String slug) {
    return this.mapper.toDto(
        this.service.findBySlug(slug)
            .orElseThrow(() -> new NotFoundException(BLOG_POST_NOT_FOUND))
    );
  }

  @Override
  public boolean existsBySlug(String slug) {
    return this.service.existsBySlug(slug);
  }

  @Override
  public Page<BlogPostResponse> findBySlugIn(Pageable pageable, List<String> slugs) {
    return this.mapper.toDto(
        this.service.findBySlugIn(slugs, pageable), pageable
    );
  }

  public BlogPost findPost(UUID uuid) {
    return this.service.findByUuid(uuid)
        .orElseThrow(() -> new NotFoundException(BLOG_POST_NOT_FOUND, uuid))
        ;
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.service.deleteByUuid(uuid);
  }
}
