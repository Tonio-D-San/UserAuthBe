package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.BaseResponse;
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
public class RulesetResponse extends BaseResponse {
  @Schema(
      description = "Codice logico del sistema di regole (identifica la famiglia di versioni).",
      example = "ALARION"
  )
  private String code;

  @Schema(
      description = "Versione del ruleset all'interno del sistema di regole.",
      example = "2",
      minimum = "1"
  )
  private Integer version;

  @Schema(
      description = "Stato del ruleset.",
      example = "ACTIVE",
      allowableValues = {"DRAFT", "ACTIVE", "DEPRECATED"}
  )
  private String status;

  @Schema(
      description = "UUID della versione precedente del ruleset, se presente.",
      example = "a3f1c0b2-7e1d-4d5b-9c13-5a6f9d8e2c11",
      nullable = true
  )
  private UUID previousRulesetUuid;

  @Schema(
      description = "Data e ora in cui il ruleset è stato pubblicato (passaggio a ACTIVE).",
      example = "2026-01-25T10:15:30Z",
      nullable = true
  )
  private Long publishedAt;

  @Schema(
      description = "Name of ruleset.",
      example = "Campaign name – Base Roles"
  )
  private String name;

  @Schema(
      description = "Description of ruleset.",
      example = "Roles for this campaign"
  )
  private String description;

  @Schema(
      description = "Number of starting points assigned to a character at creation.",
      example = "16"
  )
  private Integer initialPoints;

  @Schema(
      description = "Number of points that MUST be spent at character creation.",
      example = "15"
  )
  private Integer requiredSpendPoints;

  @Schema(
      description = "Number of points that MUST be spent at character creation.",
      example = "16",
      nullable = true
  )
  private Integer maxPointsAtCreation;

  @Schema(
      description = "Indicates whether this ruleset is currently active.",
      example = "true"
  )
  private Boolean active;
}
