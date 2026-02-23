package it.asansonne.blog.ccsr.repository;

import it.asansonne.blog.model.BlogTag;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogTagRepository extends
    BlogBaseRepository<BlogTag>
{
  Optional<BlogTag> findByNameIgnoreCase(String name);

  Page<BlogTag> findByUuidIn(List<UUID> uuids, Pageable pageable);

}


