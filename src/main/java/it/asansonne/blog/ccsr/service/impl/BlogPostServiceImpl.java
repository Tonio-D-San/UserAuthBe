package it.asansonne.blog.ccsr.service.impl;

import it.asansonne.blog.ccsr.repository.BlogPostRepository;
import it.asansonne.blog.ccsr.service.BlogPostService;
import it.asansonne.blog.model.BlogPost;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {
  private final BlogPostRepository repository;

  @Override
  public Optional<BlogPost> findByUuid(UUID uuid) {
    return repository.findByUuid(uuid);
  }

  @Override
  public Page<BlogPost> findByIsActive(Pageable pageable, Boolean isActive) {
    return repository.findAllByIsActive(isActive, pageable);
  }

  @Override
  public Page<BlogPost> findAll(Pageable pageable, Locale locale) {
    return repository.findAll(pageable);
  }

  @Override
  public void update(BlogPost model) {
    this.create(model);
  }

  @Override
  public BlogPost create(BlogPost model) {
    return repository.save(model);
  }

  @Override
  public Optional<BlogPost> findBySlug(String slug) {
    return repository.findBySlug(slug);
  }

  @Override
  public boolean existsBySlug(String slug) {
    return repository.existsBySlug(slug);
  }

  @Override
  public Page<BlogPost> findBySlugIn(List<String> slugs, Pageable pageable) {
    return repository.findBySlugIn(slugs, pageable);
  }

  @Override
  public Optional<BlogPost> findBySlugAndStatus(String slug, String status) {
    return repository.findBySlugAndStatus(slug, status);
  }

  @Override
  public Page<BlogPost> findByStatusOrderByPublishedAtDesc(String status, Pageable pageable) {
    return repository.findByStatusOrderByCreatedAtDesc(status, pageable);
  }

  @Override
  public Optional<BlogPost> findWithTagsBySlugAndStatus(String slug, String status) {
    return repository.findWithTagsBySlugAndStatus(slug, status);
  }

  @Override
  public Page<BlogPost> findPublishedWithTags(String status, Pageable pageable) {
    return repository.findPublishedWithTags(status, pageable);
  }

  @Override
  public Page<BlogPost> findByStatusAndTagSlug(String status, String tagSlug, Pageable pageable) {
    return repository.findByStatusAndTagSlug(status, tagSlug, pageable);
  }

  @Override
  public Page<BlogPost> searchPublished(String status, String q, Pageable pageable) {
    return repository.searchPublished(status, q, pageable);
  }

  @Override
  public Page<BlogPost> searchByPrefix(String status, String prefix, Pageable pageable) {
    return null;
  }

  @Override
  public Page<BlogPost> searchBySlugContains(String status, String q, Pageable pageable) {
    return null;
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.repository.delete(
        this.findByUuid(uuid)
            .orElseThrow(() -> new EntityNotFoundException("blogPost.not.found"))
    );
  }
}
