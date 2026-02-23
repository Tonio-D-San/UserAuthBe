package it.asansonne.blog.ccsr.service;

import it.asansonne.blog.model.BlogTag;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogTagService extends
    BlogBaseService<BlogTag>
{
  Optional<BlogTag> findByNameIgnoreCase(String name);

  Page<BlogTag> findByUuidIn(List<UUID> uuids, Pageable pageable);

}
