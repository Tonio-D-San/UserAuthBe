package it.asansonne.blog.ccsr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.asansonne.authhub.exception.ExceptionMessage;
import it.asansonne.blog.dto.request.BlogRequest;
import it.asansonne.blog.dto.response.BlogPageResponse;
import it.asansonne.blog.dto.response.BlogResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface BlogController<T extends BlogRequest, V extends BlogResponse> extends
    BlogBaseController<T, V> {
  @Operation(summary = "resource.find.by.slug")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.200.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = BlogPageResponse.class)
          )
      ),
      @ApiResponse(
          responseCode = "401",
          description = "resource.401.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = {
                  @io.swagger.v3.oas.annotations.media.ExampleObject(
                      name = "401 - UNAUTHORIZED",
                      value = """
                          {
                            "status": "UNAUTHORIZED",
                            "message": "Unauthorized message"
                          }"""
                  )
              },
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "403",
          description = "resource.403.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = {
                  @io.swagger.v3.oas.annotations.media.ExampleObject(
                      name = "403 - FORBIDDEN",
                      value = """
                          {
                            "status": "FORBIDDEN",
                            "message": "Forbidden message"
                          }"""
                  )
              },
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "404",
          description = "resource.404.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = {
                  @io.swagger.v3.oas.annotations.media.ExampleObject(
                      name = "404 - NOT FOUND",
                      value = """
                          {
                            "status": "NOT_FOUND",
                            "message": "Not found message",
                            "validations": null
                          }"""
                  )
              },
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      )
  })
  @GetMapping(value = "/pages/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  V findBySlugAndStatus(
      @Parameter(
          name = "slug",
          description = "Page slug",
          example = "alarion-eventi"
      )
      @PathVariable String slug,
      @RequestParam(defaultValue = "PUBLISHED") String status
  );

  @Operation(summary = "resource.find.pages.by.status")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.200.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = Page.class)
          )
      ),
      @ApiResponse(
          responseCode = "401",
          description = "resource.401.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "403",
          description = "resource.403.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      )
  })
  @GetMapping(value = "/pages", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  Page<V> findByStatusOrderByPublishedAtDesc(
      @Parameter(name = "page.name", description = "page.description") Integer page,
      @Parameter(name = "size.name", description = "size.description") Integer size,
      @Parameter(name = "direction.name", description = "direction.description") String direction,
      @Parameter(name = "status", description = "Page status filter", example = "PUBLISHED")
      @RequestParam(defaultValue = "PUBLISHED") String status);

  @Operation(summary = "resource.find.page.with.tags.by.slug")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.200.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = BlogPageResponse.class)
          )
      ),
      @ApiResponse(
          responseCode = "401",
          description = "resource.401.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "403",
          description = "resource.403.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "404",
          description = "resource.404.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      )
  })
  @GetMapping(value = "/pages/{slug}/with-tags", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  V findWithTagsBySlugAndStatus(
      @Parameter(name = "slug", description = "Page slug", example = "alarion-eventi")
      @PathVariable String slug,
      @Parameter(name = "status", description = "Page status filter", example = "PUBLISHED")
      @RequestParam(defaultValue = "PUBLISHED") String status
  );

  @Operation(summary = "resource.find.page.with.tags.by.slug")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.200.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = BlogPageResponse.class)
          )
      ),
      @ApiResponse(
          responseCode = "401",
          description = "resource.401.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "403",
          description = "resource.403.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "404",
          description = "resource.404.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      )
  })
  @GetMapping(value = "/pages/status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  Page<V> findPublishedWithTags(
      @Parameter(name = "page.name", description = "page.description") Integer page,
      @Parameter(name = "size.name", description = "size.description") Integer size,
      @Parameter(name = "direction.name", description = "direction.description") String direction,
      @PathVariable String status
  );

  @Operation(summary = "resource.find.pages.by.tag.slug")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.200.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = Page.class)
          )
      ),
      @ApiResponse(
          responseCode = "401",
          description = "resource.401.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "403",
          description = "resource.403.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      )
  })
  @GetMapping(value = "/pages/by-tag/{tagSlug}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  Page<V> findByStatusAndTagSlug(
      @Parameter(name = "page.name", description = "page.description") Integer page,
      @Parameter(name = "size.name", description = "size.description") Integer size,
      @Parameter(name = "direction.name", description = "direction.description") String direction,
      @Parameter(name = "tagSlug", description = "Tag slug", example = "eventi")
      @PathVariable String tagSlug,
      @Parameter(name = "status", description = "Page status filter", example = "PUBLISHED")
      @RequestParam(defaultValue = "PUBLISHED") String status
  );

  @Operation(summary = "resource.find.page.with.tags.by.slug")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.200.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = BlogPageResponse.class)
          )
      ),
      @ApiResponse(
          responseCode = "401",
          description = "resource.401.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "403",
          description = "resource.403.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      ),
      @ApiResponse(
          responseCode = "404",
          description = "resource.404.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class)
          )
      )
  })
  @GetMapping(value = "/pages/published", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  Page<V> searchPublished(
      @Parameter(name = "page.name", description = "page.description") Integer page,
      @Parameter(name = "size.name", description = "size.description") Integer size,
      @Parameter(name = "direction.name", description = "direction.description") String direction,
      String status, String q
  );

}
