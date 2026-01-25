package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
import it.asansonne.management.enumeration.objects.MoneyName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Character Request DTO")
public class MoneyResponse extends BaseResponse {
  @Schema(
      description = "Reagent name",
      name = "name",
      type = "String",
      example = "GOLD"
  )
  private MoneyName name;

  @Schema(
      description = "Character name",
      name = "description",
      type = "String",
      example = "Gold"
  )
  private String description;

  @Schema(
      description = "Character response",
      name = "character",
      type = "CharacterResponse",
      example = "PG Pro Character"
  )
  private CharacterResponse character;
}
