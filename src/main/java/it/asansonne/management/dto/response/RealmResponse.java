package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
import it.asansonne.authhub.dto.Response;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Realm Response DTO")
public class RealmResponse extends BaseResponse {
  @Schema(
      description = "Realm name",
      name = "name",
      type = "String",
      example = "Coronor"
  )
  private String name;

  @Schema(
      description = "Character response",
      name = "character",
      type = "CharacterResponse",
      example = "PG Pro Character"
  )
  private CharacterResponse character;
}
