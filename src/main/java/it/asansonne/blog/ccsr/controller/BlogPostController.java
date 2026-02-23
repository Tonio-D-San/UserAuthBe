package it.asansonne.blog.ccsr.controller;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.blog.dto.request.BlogPostRequest;
import it.asansonne.blog.dto.response.BlogPostResponse;

@Tag(name = "BlogPostController" + AUTH_HUB_API_VERSION)
public interface BlogPostController extends
    BlogController<BlogPostRequest, BlogPostResponse>
{

}
