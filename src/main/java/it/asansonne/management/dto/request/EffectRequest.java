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
public class EffectRequest implements Request {

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
      description = "Codice tecnico stabile dell'effetto.",
      example = "BLEEDING"
  )
  private String code;

  @NotBlank
  @Schema(
      description = "Nome leggibile.",
      example = "Sanguinamento"
  )
  private String name;

  @Schema(
      description = "Descrizione."
  )
  private String description;
}
