package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "Representation of the Realm Request DTO")
public class RealmRequest implements Request {

  @NotNull(message = "The ruleset uuid must not be null")
  @Schema(
      description = "Ruleset uuid",
      name = "rulesetUuid",
      type = "UUID",
      example = "207db025-4e57-42c2-a710-42cc4354af18"
  )
  private UUID rulesetUuid;

  @NotBlank
  @Schema(
      description = "Realm name",
      example = "Coronor"
  )
  private String name;

  @Schema(
      description = "Descrizione del realm",
      example = "Realm di Coronor",
      hidden = true
  )
  private String description;

  @Schema(
      description = "Maxim del realm",
      example = "Chi corre sul gelo poi scivola"
  )
  private String maxim;
}
