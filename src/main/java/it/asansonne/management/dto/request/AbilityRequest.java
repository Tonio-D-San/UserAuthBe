package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import it.asansonne.management.enumeration.character.AbilityName;
import jakarta.validation.constraints.NotBlank;
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
public class AbilityRequest implements Request {
  @NotBlank(message = "Ability name must not be null or empty")
  @Schema(
      description = "Ability for your PG",
      name = "abilityName",
      type = "AbilityName",
      example = "CARTOGRAPHER")
  private AbilityName abilityName;
}
