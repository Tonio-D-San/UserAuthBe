package it.asansonne.blog.ccsr.component;

import it.asansonne.blog.dto.request.BlogBaseRequest;
import it.asansonne.blog.dto.response.BlogBaseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogComponent<T extends BlogBaseRequest, V extends BlogBaseResponse> extends
    BlogBaseComponent<T, V>
{
  V findBySlugAndStatus(String slug, String status);

  Page<V> findByStatusOrderByPublishedAtDesc(Pageable pageable, String status);

  V findWithTagsBySlugAndStatus(String slug, String status);

  Page<V> findPublishedWithTags(Pageable pageable, String status);

  Page<V> findByStatusAndTagSlug(Pageable pageable, String status, String tagSlug);

  Page<V> searchPublished(Pageable pageable, String status, String q);

}
