package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Training Request DTO")
public class TrainingAbilityGrantResponse extends BaseResponse {

  @Schema(
      description = "UUID del training.",
      example = "a3f1c0b2-7e1d-4d5b-9c13-5a6f9d8e2c11"
  )
  private TrainingResponse training;

  @Schema(
      description = "UUID dell'abilità.",
      example = "b8b5c6d3-9b4a-4c31-9a44-1e2f4d9a0b99"
  )
  private AbilityResponse ability;

  @Schema(
      description = "Rank concesso.",
      example = "1"
  )
  private Integer rankGranted;
}
