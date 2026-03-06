package it.asansonne.blog.ccsr.service;

import it.asansonne.blog.model.BlogModel;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService<T extends BlogModel> extends
    BlogBaseService<T>
{
  Optional<T> findBySlugAndStatus(String slug, String status);

  Page<T> findByStatusOrderByPublishedAtDesc(String status, Pageable pageable);

  Optional<T> findWithTagsBySlugAndStatus(String slug, String status);

  Page<T> findPublishedWithTags(String status, Pageable pageable);

  Page<T> findByStatusAndTagSlug(String status, String tagSlug, Pageable pageable);

  Page<T> searchPublished(String status, String q, Pageable pageable);

  Page<T> searchByPrefix(String status, String prefix, Pageable pageable);

  Page<T> searchBySlugContains(String status, String q, Pageable pageable);

}
