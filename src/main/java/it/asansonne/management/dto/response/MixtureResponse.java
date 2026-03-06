package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.BaseResponse;
import java.util.List;
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
public class MixtureResponse extends BaseResponse {

  private RulesetResponse ruleset;

  private AlchemyPathResponse alchemyPat;
  private ItemResponse producedItem;

  @Schema(
      description = "Code name",
      name = "code",
      type = "String",
      example = "Code"
  )
  private String code;

  @Schema(
      description = "Mixture name",
      name = "name",
      type = "String",
      example = "Mixture"
  )
  private String name;

  @Schema(
      description = "Mixture description",
      name = "description",
      type = "String",
      example = "Descrizione della mistura"
  )
  private String description;

  @Schema(
      description = "Tier della mistura (es: BASE, APPRENDISTA, ESPERTO).",
      name = "tier",
      type = "String",
      example = "BASE"
  )
  private String tier;

  @Schema(
      description = "Is acrive",
      name = "active",
      type = "Boolean",
      example = "true"
  )
  private Boolean active;

  @Schema(
      description = "Character response",
      name = "characters",
      type = "CharacterResponse"
  )
  private List<CharacterResponse> characters;
}
