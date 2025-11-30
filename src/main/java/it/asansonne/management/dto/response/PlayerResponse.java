package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Response;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Player Request DTO")
public class PlayerResponse implements Response {
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @Schema(
      description = "Player uuid",
      name = "playerUuid",
      type = "UUID",
      example = "08fba211-60ca-45fc-b809-86bc2ad81dca")
  private UUID uuid;

  @NotBlank(message = "Player name")
  @Schema(
      description = "Player name",
      name = "name",
      type = "String",
      example = "mrossi"
  )
  private String name;

  @NotBlank(message = "User surname must not be null or empty")
  @Schema(
      description = "Realm response",
      name = "realm",
      type = "RealmResponse",
      example = "Coronor")
  private RealmResponse realm;
}
