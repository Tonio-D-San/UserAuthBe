package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.Request;
import it.asansonne.management.enumeration.objects.MoneyName;
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
@Schema(description = "Representation of the Money Request DTO")
public class MoneyRequest implements Request {

  @NotNull(message = "Money name must not be null")
  @Schema(description = "Money type.", example = "GOLD")
  private MoneyName moneyName;
}
