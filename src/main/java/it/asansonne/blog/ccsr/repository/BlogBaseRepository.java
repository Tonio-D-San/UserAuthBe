package it.asansonne.blog.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.blog.model.BlogBaseModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BlogBaseRepository<T extends BlogBaseModel>
    extends GetRepository<T> {

  Optional<T> findBySlug(String slug);

  boolean existsBySlug(String slug);

  Page<T> findBySlugIn(List<String> slugs, Pageable pageable);
}


