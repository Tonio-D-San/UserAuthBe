package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import it.asansonne.management.enumeration.ReagentName;
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
@Schema(description = "Representation of the Reagent Request DTO")
public class ReagentRequest implements Request {

  @NotNull(message = "Reagent name must not be null")
  @Schema(description = "Reagent type.", example = "MANDRAGORA")
  private ReagentName reagentName;
}
