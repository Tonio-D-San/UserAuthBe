package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.Request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "Representation of the Card Request DTO")
public class CardRequest implements Request {

  @NotNull(message = "Total points must not be null")
  @Min(value = 0, message = "Total points must be >= 0")
  @Schema(description = "Total points available at character creation (master-controlled).", example = "16")
  private Integer totalPoints;

  @Builder.Default
  @Min(value = 0, message = "Minimum spend points must be >= 0")
  @Schema(description = "Minimum points that must be spent at creation.", example = "15")
  private Integer minSpendPoints = 15;

  @Builder.Default
  @Min(value = 0, message = "Ability cost must be >= 0")
  @Schema(description = "Points cost for a single ability.", example = "3")
  private Integer abilityCost = 3;

  @Builder.Default
  @Min(value = 0, message = "Free abilities must be >= 0")
  @Schema(description = "Number of free abilities (e.g. granted by training).", example = "1")
  private Integer freeAbilities = 0;
}
