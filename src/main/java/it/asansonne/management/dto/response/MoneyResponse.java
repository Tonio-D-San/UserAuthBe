package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Response;
import it.asansonne.management.enumeration.ReagentName;
import it.asansonne.management.enumeration.objects.MoneyName;
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
public class MoneyResponse implements Response {
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @Schema(
      description = "Character uuid",
      name = "uuid",
      type = "UUID",
      example = "08fba211-60ca-45fc-b809-86bc2ad81dca")
  private UUID uuid;

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
