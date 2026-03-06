package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.BaseResponse;
import jakarta.validation.Valid;
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
@Schema(description = "Representation of the Character Request DTO")
public class CardResponse extends BaseResponse {
  @Schema(
      description = "Character name",
      name = "name",
      type = "String",
      example = "Zaino di mrossi"
  )
  private String name;

  @Schema(
      description = "Character name",
      name = "description",
      type = "String",
      example = "Zaino da viaggio"
  )
  private String description;

  @Valid
  @Schema(
      description = "Money items inside the bag.",
      name = "money",
      type = "List<MoneyResponse>",
      example = "Money in the bag"
  )
  private List<MoneyResponse> money;

  @Valid
  @Schema(
      description = "Reagents inside the bag.",
      name = "reagents",
      type = "List<ReagentResponse>",
      example = "Reagent in the bag"
  )
  private List<ReagentResponse> reagents;

  @Schema(
      description = "Character response",
      name = "character",
      type = "CharacterResponse",
      example = "PG Pro Character"
  )
  private CharacterResponse character;
}
