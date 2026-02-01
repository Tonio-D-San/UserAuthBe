package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Realm Response DTO")
public class ItemResponse extends BaseResponse {

  private RulesetResponse ruleset;

  @Schema(
      description = "Code name",
      name = "code",
      type = "String",
      example = "Code"
  )
  private String code;

  @Schema(
      description = "Item name",
      name = "name",
      type = "String",
      example = "Item"
  )
  private String name;

  @Schema(
      description = "Item description",
      name = "description",
      type = "String",
      example = "Descrizione dell'item"
  )
  private String description;

  @NotNull
  @Schema(
      description = "Se true, l'item viene consumato all'uso.",
      example = "true"
  )
  private Boolean consumable;

  @NotNull
  @Schema(
      description = "Se true, può essere impilato (qty > 1).",
      example = "true"
  )
  private Boolean stackable;

  @NotNull
  @Schema(
      description = "Se è attivo o meno.",
      example = "true"
  )
  private Boolean isActive;
}
