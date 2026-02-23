package it.asansonne.blog.ccsr.service;

import it.asansonne.authhub.ccsr.service.DeleteService;
import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.blog.model.BlogBaseModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogBaseService<T extends BlogBaseModel> extends
    GetService<T>,
    PatchService<T>,
    PostService<T>,
    DeleteService
{
  Optional<T> findBySlug(String slug);

  boolean existsBySlug(String slug);

  Page<T> findBySlugIn(List<String> slugs, Pageable pageable);
}
