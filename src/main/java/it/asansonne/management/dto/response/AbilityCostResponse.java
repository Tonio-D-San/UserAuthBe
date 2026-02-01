package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class AbilityCostResponse extends BaseResponse {

  private AbilityResponse abilityResponse;

  @NotNull
  @Min(1)
  @Schema(
      description = "Rank minimo richiesto sull'abilità richiesta.",
      example = "1",
      minimum = "1"
  )
  private Integer requiredRank;
}
