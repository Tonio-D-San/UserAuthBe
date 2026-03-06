package it.asansonne.blog.ccsr.component;

import it.asansonne.common.ccsr.component.DeleteComponent;
import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.blog.dto.request.BlogBaseRequest;
import it.asansonne.blog.dto.response.BlogBaseResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogBaseComponent<T extends BlogBaseRequest, V extends BlogBaseResponse> extends
    GetComponent<V>,
    PatchComponent<T>,
    PostComponent<T, V>,
    DeleteComponent
{
  V findBySlug(String slug);

  boolean existsBySlug(String slug);

  Page<V> findBySlugIn(Pageable pageable, List<String> slugs);
}
