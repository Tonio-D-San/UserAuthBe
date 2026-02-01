package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
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
@Schema(description = "Representation of the Mixture Request DTO")
public class MixtureEffectRequest implements Request {

  @NotNull
  @Schema(
      description = "UUID dell'effetto (catalogo)."
  )
  private UUID effectUuid;

  @Schema(
      description = "Intensità/valore generico dell'effetto.",
      example = "1",
      nullable = true
  )
  private Integer magnitude;

  @Min(0)
  @Schema(
      description = "Durata in secondi (null se istantaneo).",
      example = "60",
      nullable = true,
      minimum = "0"
  )
  private Integer durationSeconds;

}
