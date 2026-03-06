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
@Schema(description = "Representation of the Ability Response DTO")
public class AbilityResponse extends BaseResponse {

  private RulesetResponse ruleset;

  @Schema(
      description = "Ability code",
      name = "code",
      type = "String",
      example = "CARTOGRAPHER")
  private String code;

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

  private List<AbilityCostResponse> costResponseList;

  private List<AbilityPrerequisiteResponse> prerequisiteResponseList;

}
