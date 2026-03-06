package it.asansonne.blog.ccsr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.asansonne.common.ccsr.controller.DeleteController;
import it.asansonne.common.ccsr.controller.GetController;
import it.asansonne.common.ccsr.controller.PatchController;
import it.asansonne.common.ccsr.controller.PostController;
import it.asansonne.authhub.exception.ExceptionMessage;
import it.asansonne.blog.dto.request.BlogBaseRequest;
import it.asansonne.blog.dto.response.BlogBaseResponse;
import it.asansonne.blog.dto.response.BlogTagResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface BlogBaseController<T extends BlogBaseRequest, V extends BlogBaseResponse> extends
    GetController<V> ,
    PatchController<T>,
    PostController<T, V>,
    DeleteController
{
  @Operation(summary = "resource.find.by.slug")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.201.description"
      ), @ApiResponse(
      responseCode = "401",
      description = "resource.401.description",
      content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          examples = {
              @ExampleObject(
                  name = "401 - UNAUTHORIZED",
                  value = """
                      {
                      "status": "UNAUTHORIZED",
                      "message": \
                      "Unauthorized message"
                       }"""
              )
          },
          schema = @Schema(implementation = ExceptionMessage.class)
      )
  ), @ApiResponse(
      responseCode = "403",
      description = "resource.403.description",
      content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          examples = {
              @ExampleObject(
                  name = "403 - FORBIDDEN",
                  value = """
                      {
                      "status": "FORBIDDEN",
                      "message": \
                      "Forbidden message"
                      }"""
              )
          },
          schema = @Schema(implementation = ExceptionMessage.class)
      )
  ), @ApiResponse(
      responseCode = "404",
      description = "resource.404.description",
      content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          examples = {
              @ExampleObject(
                  name = "404 - NOT FOUND",
                  value = """
                      {
                      "status": "NOT_FOUND",
                      "message": \
                      "Not found message"
                      , "validations": \
                      null }"""
              )
          },
          schema = @Schema(implementation = ExceptionMessage.class)
      )
  )
  })
  @GetMapping(value = "/page/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  V findBySlug(@Parameter(
      name = "slug",
      description = "page's slug",
      example = "welcome-page"
  ) @PathVariable String slug);

  @Operation(summary = "resource.exists.by.slug")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.exists.200.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = Boolean.class),
              examples = {
                  @ExampleObject(name = "Exists", value = "true"),
                  @ExampleObject(name = "Does not exist", value = "false")
              }
          )
      ),
      @ApiResponse(
          responseCode = "401",
          description = "resource.401.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = {
                  @ExampleObject(
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
                  @ExampleObject(
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
      )
  })
  @GetMapping(value = "/exists/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  boolean existsBySlug(@PathVariable String slug);

  @Operation(summary = "resource.find.tags.by.slugs")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.200.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = BlogTagResponse.class)
          )
      ),
      @ApiResponse(
          responseCode = "401",
          description = "resource.401.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class),
              examples = {
                  @ExampleObject(
                      name = "401 - UNAUTHORIZED",
                      value = """
                        {
                          "status": "UNAUTHORIZED",
                          "message": "Unauthorized message"
                        }"""
                  )
              }
          )
      ),
      @ApiResponse(
          responseCode = "403",
          description = "resource.403.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = ExceptionMessage.class),
              examples = {
                  @ExampleObject(
                      name = "403 - FORBIDDEN",
                      value = """
                        {
                          "status": "FORBIDDEN",
                          "message": "Forbidden message"
                        }"""
                  )
              }
          )
      )
  })
  @GetMapping(value = "/tags", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  Page<V> findBySlugIn(
      @Parameter(name = "page.name", description = "page.description") Integer page,
      @Parameter(name = "size.name", description = "size.description") Integer size,
      @Parameter(name = "direction.name", description = "direction.description") String direction,
      @RequestParam(name = "slugs") List<String> slugs
  );

}
