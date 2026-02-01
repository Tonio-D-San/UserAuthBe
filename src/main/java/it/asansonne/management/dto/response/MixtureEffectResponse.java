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
@Schema(description = "Representation of the Realm Response DTO")
public class MixtureEffectResponse extends BaseResponse {

  private RulesetResponse ruleset;

  private MixtureResponse mixture;
  private EffectResponse effect;

  @Schema(
      description = "Intensità/valore generico dell'effetto.",
      example = "1"
  )
  private Integer magnitude;

  @Schema(
      description = "Durata in secondi.",
      example = "60",
      minimum = "0"
  )
  private Integer durationSeconds;
}
