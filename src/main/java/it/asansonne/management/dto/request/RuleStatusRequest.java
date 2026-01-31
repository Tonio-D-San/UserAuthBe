package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.request.StatusRequest;
import it.asansonne.management.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Ruleset Request DTO")
public class RuleStatusRequest extends StatusRequest {
  @Schema(
      description = "Status",
      name = "status",
      type = "Status",
      example = "DRAFT or ACTIVE or DEPRECATED",
      defaultValue = "DRAFT"
  )
  private Status status;

}
