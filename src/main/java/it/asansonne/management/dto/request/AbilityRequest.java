package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.Request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Ability Request DTO")
public class AbilityRequest implements Request {
  @NotNull
  @Schema(
      description = "UUID del ruleset proprietario.",
      name = "rulesetUuid",
      type = "UUID",
      example = "c8b5c6d3-9b4a-4c31-9a44-1e2f4d9a0b2e"
  )
  private UUID rulesetUuid;

  @NotBlank
  @Schema(
      description = "Codice tecnico stabile.",
      name = "code",
      type = "String",
      example = "CARTOGRAPHER"
  )
  private String code;

  @NotBlank
  @Schema(
      description = "Nome leggibile.",
      name = "name",
      type = "String",
      example = "Cartografo"
  )
  private String name;

  @Schema(
      description = "Descrizione.",
      name = "description",
      type = "String",
      example = "Descrizione"
  )
  private String description;

  @NotNull
  @Schema(
      description = "Se true, l'abilità ha rank multipli.",
      name = "repeatable",
      type = "Boolean",
      example = "false"
  )
  private Boolean repeatable;

  @Min(1)
  @Schema(
      description = "Rank massimo (obbligatorio se repeatable=true).",
      name = "maxRank",
      type = "Integer",
      example = "3",
      nullable = true
  )
  private Integer maxRank;
}
