package it.asansonne.blog.ccsr.service.impl;

import it.asansonne.blog.ccsr.repository.BlogPageRepository;
import it.asansonne.blog.ccsr.service.BlogPageService;
import it.asansonne.blog.model.BlogPage;
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
public class BlogPageServiceImpl implements BlogPageService {
  private final BlogPageRepository repository;

  @Override
  public Optional<BlogPage> findByUuid(UUID uuid) {
    return repository.findByUuid(uuid);
  }

  @Override
  public Page<BlogPage> findByIsActive(Pageable pageable, Boolean isActive) {
    return repository.findAllByIsActive(isActive, pageable);
  }

  @Override
  public Page<BlogPage> findAll(Pageable pageable, Locale locale) {
    return repository.findAll(pageable);
  }

  @Override
  public void update(BlogPage model) {
    this.create(model);
  }

  @Override
  public BlogPage create(BlogPage model) {
    return repository.save(model);
  }

  @Override
  public Optional<BlogPage> findBySlug(String slug) {
    return repository.findBySlug(slug);
  }

  @Override
  public boolean existsBySlug(String slug) {
    return repository.existsBySlug(slug);
  }

  @Override
  public Page<BlogPage> findBySlugIn(List<String> slugs, Pageable pageable) {
    return repository.findBySlugIn(slugs, pageable);
  }

  @Override
  public Optional<BlogPage> findBySlugAndStatus(String slug, String status) {
    return repository.findBySlugAndStatus(slug, status);
  }

  @Override
  public Page<BlogPage> findByStatusOrderByPublishedAtDesc(String status, Pageable pageable) {
    return repository.findByStatusOrderByCreatedAtDesc(status, pageable);
  }

  @Override
  public Optional<BlogPage> findWithTagsBySlugAndStatus(String slug, String status) {
    return  repository.findWithTagsBySlugAndStatus(slug, status);
  }

  @Override
  public Page<BlogPage> findPublishedWithTags(String status, Pageable pageable) {
    return repository.findPublishedWithTags(status, pageable);
  }

  @Override
  public Page<BlogPage> findByStatusAndTagSlug(String status, String tagSlug, Pageable pageable) {
    return repository.findByStatusAndTagSlug(status, tagSlug, pageable);
  }

  @Override
  public Page<BlogPage> searchPublished(String status, String q, Pageable pageable) {
    return repository.searchPublished(status, q, pageable);
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.repository.delete(
        this.findByUuid(uuid)
            .orElseThrow(() -> new EntityNotFoundException("blogPage.not.found"))
    );
  }
}
