package it.asansonne.blog.ccsr.component;

import it.asansonne.blog.dto.request.BlogTagRequest;
import it.asansonne.blog.dto.response.BlogTagResponse;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogTagComponent extends
    BlogBaseComponent<BlogTagRequest, BlogTagResponse> {
  BlogTagResponse findByNameIgnoreCase(String name);

  Page<BlogTagResponse> findByUuidIn(Pageable pageable, List<UUID> uuids);

}
