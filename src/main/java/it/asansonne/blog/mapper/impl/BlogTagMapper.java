package it.asansonne.blog.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.blog.dto.request.BlogTagRequest;
import it.asansonne.blog.dto.response.BlogTagResponse;
import it.asansonne.blog.model.BlogTag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogTagMapper implements
    RequestMapper<BlogTagRequest, BlogTag>, ResponseMapper<BlogTag, BlogTagResponse> {

  @Override
  public BlogTag toModel(BlogTagRequest dto) {
    return dto == null ? null : BlogTag.builder()
        .name(dto.getName())
        .slug(dto.getSlug())
        .build();
  }


  @Override
  public BlogTagResponse toDto(BlogTag model) {
    return model == null ? null : BlogTagResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .name(model.getName())
        .slug(model.getSlug())
        .build();
  }

}
