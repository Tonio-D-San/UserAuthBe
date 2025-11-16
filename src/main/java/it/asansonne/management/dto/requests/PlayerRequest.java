package it.asansonne.management.dto.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import jakarta.validation.constraints.NotBlank;
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
public class PlayerRequest implements Request {
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
      description = "User surname",
      name = "lastname",
      type = "Enum",
      example = "Coronor")
  private RealmRequest realm;
}
