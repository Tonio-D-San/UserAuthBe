package it.asansonne.authhub.ccsr.controller.users;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.authhub.ccsr.controller.DeleteController;
import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.ExceptionMessage;
import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The interface User controller v1.
 */
@Tag(name = "UserController" + AUTH_HUB_API_VERSION)
public interface UserControllerV1 extends
    GetController<UserRequest, UserResponse>,
    PostController<UserRequest, UserResponse>,
    PatchController<UserRequest, UserResponse>,
    DeleteController
{
  @Operation(summary = "resource.find.me")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "resource.find.201.description",
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = UserResponse.class)
          )
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
  @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  UserResponse me(Principal principal, Authentication authentication);
}

