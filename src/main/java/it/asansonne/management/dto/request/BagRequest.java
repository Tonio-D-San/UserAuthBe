package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.Request;
import jakarta.validation.Valid;
import java.util.List;
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
@Schema(description = "Representation of the Bag Request DTO")
public class BagRequest implements Request {

  @Schema(
      description = "Bag name.",
      example = "Zaino di mrossi"
  )
  private String name;

  @Schema(
      description = "Bag description.",
      example = "Zaino da viaggio"
  )
  private String description;

  @Valid
  @Schema(
      description = "Money items inside the bag."
  )
  private List<MoneyRequest> money;

  @Valid
  @Schema(
      description = "Reagents inside the bag."
  )
  private List<ReagentRequest> reagents;
}
