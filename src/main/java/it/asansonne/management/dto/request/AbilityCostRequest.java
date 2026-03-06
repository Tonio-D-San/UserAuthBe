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
public class AbilityCostRequest implements Request {
  @NotNull @Min(1)
  @Schema(
      description = "Rank a cui si applica il costo.",
      example = "1",
      minimum = "1"
  )
  private Integer rank;

  @NotNull @Min(0)
  @Schema(
      description = "Costo in punti.",
      example = "3",
      minimum = "0"
  )
  private Integer cost;
}
