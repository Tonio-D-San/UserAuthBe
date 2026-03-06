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
@Schema(description = "Representation of the Mixture Request DTO")
public class MixtureIngredientRequest implements Request {
  @NotNull
  @Schema(
      description = "UUID dell'item usato come ingrediente."
  )
  private UUID itemUuid;

  @NotNull @Min(1)
  @Schema(
      description = "Quantità richiesta.",
      example = "1",
      minimum = "1"
  )
  private Integer qty;
}
