package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.Request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Ability Request DTO")
public class AbilityPrerequisiteRequest implements Request {

  @NotNull
  @Schema(
      description = "UUID dell'abilità richiesta.",
      example = "b8b5c6d3-9b4a-4c31-9a44-1e2f4d9a0b99"
  )
  private AbilityRequest requiredAbility;

  @NotNull @Min(1)
  @Schema(
      description = "Rank minimo richiesto sull'abilità richiesta.",
      example = "1",
      minimum = "1"
  )
  private Integer requiredRank;
}
