package it.asansonne.blog.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.blog.dto.request.BlogPostRequest;
import it.asansonne.blog.dto.response.BlogPostResponse;
import it.asansonne.blog.model.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class BlogPostMapper implements
    RequestMapper<BlogPostRequest, BlogPost>, ResponseMapper<BlogPost, BlogPostResponse> {

  private final BlogTagMapper blogTagMapper;

  @Override
  public BlogPost toModel(BlogPostRequest dto) {
    return dto == null ? null : BlogPost.builder()
        .slug(dto.getSlug())
        .title(dto.getTitle())
        .excerpt(dto.getExcerpt())
        .contentMd(dto.getContentMd())
        .coverUrl(dto.getCoverUrl())
        .authorName(dto.getAuthorName())
        .status(dto.getStatusRequest().getStatus().getName())
        .tags(blogTagMapper.toModel(dto.getTags()))
        .build();
  }

  @Override
  public BlogPostResponse toDto(BlogPost model) {
    return model == null ? null : BlogPostResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .slug(model.getSlug())
        .title(model.getTitle())
        .excerpt(model.getExcerpt())
        .contentMd(model.getContentMd())
        .coverUrl(model.getCoverUrl())
        .authorName(model.getAuthorName())
        .tags(blogTagMapper.toDto(model.getTags()))
        .build();
  }

}
