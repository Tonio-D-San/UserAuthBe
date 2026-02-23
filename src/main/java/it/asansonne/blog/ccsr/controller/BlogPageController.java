package it.asansonne.blog.ccsr.controller;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.blog.dto.request.BlogPageRequest;
import it.asansonne.blog.dto.response.BlogPageResponse;

@Tag(name = "BlogPageController" + AUTH_HUB_API_VERSION)
public interface BlogPageController extends
    BlogController<BlogPageRequest, BlogPageResponse> {

}
