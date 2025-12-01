package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Response;
import it.asansonne.management.enumeration.RequirementType;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.enumeration.character.AbilityType;
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
@Schema(description = "Representation of the Ability Response DTO")
public class AbilityResponse implements Response {

  @Schema(
      description = "Ability code",
      name = "code",
      type = "String",
      example = "CARTOGRAPHER")
  private AbilityName code;

  @Schema(
      description = "Ability name",
      name = "name",
      type = "String",
      example = "Cartographer"
  )
  private String name;

  @Schema(
      description = "Ability description",
      name = "description",
      type = "String",
      example = "Before each event, the character receives a map (complete or incomplete) showing certain areas of interest or special information about the game area."
  )
  private String description;

  @Schema(
      description = "Ability type",
      name = "type",
      type = "AbilityType",
      example = "GENERIC"
  )
  private AbilityType type;

  @Schema(
      description = "Ability requirement type",
      name = "requirementType",
      type = "RequirementType",
      example = "ALONE"
  )
  private RequirementType requirementType;

}
