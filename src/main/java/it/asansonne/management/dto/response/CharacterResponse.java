package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
import it.asansonne.authhub.dto.response.UserResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Character Request DTO")
public class CharacterResponse extends BaseResponse {
  @Schema(
      description = "Character name",
      name = "name",
      type = "String",
      example = "mrossi"
  )
  private String name;

  @Schema(
      description = "Realm response",
      name = "realm",
      type = "RealmResponse",
      example = "Coronor")
  private RealmResponse realm;

  @Schema(
      description = "User response",
      name = "user",
      type = "UserResponse",
      example = "user: {}")
  private UserResponse user;
}
