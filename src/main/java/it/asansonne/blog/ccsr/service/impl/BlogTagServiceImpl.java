package it.asansonne.blog.ccsr.service.impl;

import it.asansonne.blog.ccsr.repository.BlogTagRepository;
import it.asansonne.blog.ccsr.service.BlogTagService;
import it.asansonne.blog.model.BlogTag;
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
public class BlogTagServiceImpl implements BlogTagService {
  private final BlogTagRepository repository;

  @Override
  public Optional<BlogTag> findByUuid(UUID uuid) {
    return repository.findByUuid(uuid);
  }

  @Override
  public Page<BlogTag> findByIsActive(Pageable pageable, Boolean isActive) {
    return repository.findAllByIsActive(isActive, pageable);
  }

  @Override
  public Page<BlogTag> findAll(Pageable pageable, Locale locale) {
    return repository.findAll(pageable);
  }

  @Override
  public void update(BlogTag model) {
    this.create(model);
  }

  @Override
  public BlogTag create(BlogTag model) {
    return repository.save(model);
  }

  @Override
  public Optional<BlogTag> findBySlug(String slug) {
    return repository.findBySlug(slug);
  }

  @Override
  public Optional<BlogTag> findByNameIgnoreCase(String name) {
    return repository.findByNameIgnoreCase(name);
  }

  @Override
  public boolean existsBySlug(String slug) {
    return repository.existsBySlug(slug);
  }

  @Override
  public Page<BlogTag> findBySlugIn(List<String> slugs, Pageable pageable) {
    return repository.findBySlugIn(slugs, pageable);
  }

  @Override
  public Page<BlogTag> findByUuidIn(List<UUID> uuids, Pageable pageable) {
    return repository.findByUuidIn(uuids, pageable);
  }

  @Override
  public void deleteByUuid(UUID uuid) {
    this.repository.delete(
        this.findByUuid(uuid)
            .orElseThrow(() -> new EntityNotFoundException("blogTag.not.found"))
    );
  }
}
