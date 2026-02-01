package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Ruleset Request DTO")
public class AlchemyPathRequest implements Request {
  @NotNull(message = "Ruleset UUID must be provided")
  @Schema(
      description = "Ruleset uuid",
      name = "rulesetUuid",
      type = "UUID",
      example = "207db025-4e57-42c2-a710-42cc4354af18"
  )
  private UUID rulesetUuid;

  @NotBlank(message = "Path code must not be null or empty")
  @Schema(
      description = "Codice tecnico stabile della Via (usato per referenze e seed).",
      name = "code",
      type = "String",
      example = "VIA_ORO"
  )
  private String code;

  @NotBlank(message = "Path name must not be null or empty")
  @Schema(
      description = "Nome leggibile della Via.",
      name = "name",
      type = "String",
      example = "Via dell'Oro"
  )
  private String name;

  @Schema(
      description = "Descrizione della Via (flavour e note).",
      name = "description",
      type = "String",
      example = "Percorso alchemico orientato a..."
  )
  private String description;
}
