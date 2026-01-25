package it.asansonne.authhub.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The type User response.
 */
@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the User Response DTO")
public class UserResponse extends BaseResponse {
  @Schema(
      description = "User username",
      name = "username",
      type = "String",
      example = "username")
  private String username;

  @Schema(
      description = "User email",
      name = "email",
      type = "String",
      example = "example@domain.it")
  private String email;

  @Schema(
      description = "User name",
      name = "name",
      type = "String",
      example = "Mario")
  private String firstName;

  @Schema(
      description = "User surname",
      name = "surname",
      type = "String",
      example = "Rossi")
  private String lastName;

  @Schema(
      description = "User biography",
      name = "biography",
      type = "String",
      example = "This is a biography")
  private String biography;

  @Schema(
      description = "List of groups",
      name = "groups",
      type = "List<GroupResponse>")
  private List<GroupResponse> groups;

  @Schema(
      description = "User active toggle",
      name = "isActive",
      type = "String",
      example = "true")
  private Boolean enabled;

  @Schema(
      description = "Provider",
      name = "provider",
      type = "String",
      example = "Google"
  )
  private String provider;

  @Schema(
      description = "User profile image",
      name = "profileImage",
      type = "byte[]")
  private byte[] profileImage;
}
