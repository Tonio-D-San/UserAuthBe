package it.asansonne.management.ccsr.controller.dashboard;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.ExceptionMessage;
import it.asansonne.management.dto.request.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface PlayerController extends
    GetController<PlayerRequest, PlayerResponse> ,
    PatchController<PlayerRequest, PlayerResponse>,
    PostController<PlayerRequest, PlayerResponse>
{
  @Operation(summary = "resource.find.by.ability")
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
  @ResponseStatus(HttpStatus.OK)
  PlayerResponse findByAbility(AbilityName abilityName);

}
