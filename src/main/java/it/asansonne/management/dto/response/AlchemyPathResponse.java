package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(
    name = "AlchemyPathResponse",
    description = "Rappresentazione pubblica di una Via alchemica."
)
public class AlchemyPathResponse extends BaseResponse {
  private RulesetResponse ruleset;

  @Schema(
      description = "Codice tecnico della Via.",
      example = "VIA_ESPLORAZIONE"
  )
  private String code;

  @Schema(
      description = "Nome leggibile della Via.",
      example = "Via dell'Esplorazione"
  )
  private String name;

  @Schema(
      description = "Descrizione."
  )
  private String description;

  @Schema(
      description = "Soft delete flag.",
      example = "true"
  )
  private Boolean active;
}