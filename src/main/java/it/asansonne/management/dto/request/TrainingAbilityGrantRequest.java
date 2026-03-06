package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.Request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "Representation of the Training Request DTO")
public class TrainingAbilityGrantRequest implements Request {
  @NotNull(message = "Ability UUID must be provided")
  @Schema(
      description = "UUID dell'abilità concessa dal training.",
      example = "b8b5c6d3-9b4a-4c31-9a44-1e2f4d9a0b99"
  )
  private UUID trainingUuid;

  @NotNull(message = "Ability UUID must be provided")
  @Schema(
      description = "UUID dell'abilità concessa dal training.",
      example = "b8b5c6d3-9b4a-4c31-9a44-1e2f4d9a0b99"
  )
  private UUID abilityUuid;

  @NotNull
  @Min(value = 1, message = "rankGranted must be >= 1")
  @Schema(description = "Rank concesso.", example = "1", minimum = "1")
  private Integer rankGranted;

}
