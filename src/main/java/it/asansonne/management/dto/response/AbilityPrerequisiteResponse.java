package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
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
public class AbilityPrerequisiteResponse extends BaseResponse {

  private AbilityResponse ability;

  private AbilityResponse requiredAbility;

  @Schema(
      description = "Required ability cost",
      name = "Required ability cost",
      type = "Integer",
      example = "2"
  )
  private Integer requiredRank;

}
