package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
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
@Schema(description = "Representation of the Ruleset Request DTO")
public class RulesetRequest implements Request {
  @Schema(
      description = "Name of ruleset.",
      example = "Campaign name – Base Rules"
  )
  private String name;

  @Schema(
      description = "Description of ruleset.",
      example = "Rules for this campaign"
  )
  private String description;

  @Schema(
      description = "Code of ruleset.",
      example = "Campaign"
  )
  private String code;

  @Schema(
      description = "Number of starting points assigned to a character at creation.",
      example = "16",
      minimum = "0"
  )
  private Integer initialPoints;

  @Schema(
      description = "Number of points that MUST be spent at character creation.",
      example = "15",
      minimum = "0"
  )
  private Integer requiredSpendPoints;

  @Schema(
      description = "Maximum number of points that can be spent at character creation.",
      example = "16",
      nullable = true,
      minimum = "0"
  )
  private Integer maxPointsAtCreation;

  @Schema(
      description = "Status of ruleset",
      type = "RuleStatusRequest",
      nullable = true
  )
  private RuleStatusRequest statusRequest;

}
