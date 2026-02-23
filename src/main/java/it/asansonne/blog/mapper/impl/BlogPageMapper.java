package it.asansonne.blog.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.blog.dto.request.BlogPageRequest;
import it.asansonne.blog.dto.response.BlogPageResponse;
import it.asansonne.blog.model.BlogPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class BlogPageMapper implements
    RequestMapper<BlogPageRequest, BlogPage>, ResponseMapper<BlogPage, BlogPageResponse> {

  private final BlogTagMapper blogTagMapper;

  @Override
  public BlogPage toModel(BlogPageRequest dto) {
    return dto == null ? null : BlogPage.builder()
        .slug(dto.getSlug())
        .title(dto.getTitle())
        .contentMd(dto.getContentMd())
        .status(dto.getStatusRequest().getStatus().getName())
        .tags(blogTagMapper.toModel(dto.getTags()))
        .build();
  }

  @Override
  public BlogPageResponse toDto(BlogPage model) {
    return model == null ? null : BlogPageResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .slug(model.getSlug())
        .title(model.getTitle())
        .contentMd(model.getContentMd())
        .tags(blogTagMapper.toDto(model.getTags()))
        .build();
  }

}
