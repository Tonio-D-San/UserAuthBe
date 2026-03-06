package it.asansonne.blog.ccsr.repository;

import it.asansonne.blog.model.BlogModel;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BlogRepository<T extends BlogModel>
    extends BlogBaseRepository<T> {

  Optional<T> findBySlugAndStatus(String slug, String status);

  Page<T> findByStatusOrderByCreatedAtDesc(String status, Pageable pageable);

  @EntityGraph(attributePaths = "tags")
  Optional<T> findWithTagsBySlugAndStatus(String slug, String status);

  Page<T> findPublishedWithTags(String status, Pageable pageable);

  Page<T> findByStatusAndTagSlug(String status, String tagSlug, Pageable pageable);

  Page<T> searchPublished(String status, String q, Pageable pageable);

  Page<T> searchByPrefix(String status, String prefix, Pageable pageable);

//  Page<T> searchBySlugContains(String status, String q, Pageable pageable);

}
