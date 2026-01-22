package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Response;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
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
@Schema(description = "Representation of the Character Request DTO")
public class CardResponse implements Response {
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @Schema(
      description = "Character uuid",
      name = "uuid",
      type = "UUID",
      example = "08fba211-60ca-45fc-b809-86bc2ad81dca")
  private UUID uuid;

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
