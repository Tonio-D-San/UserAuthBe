package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Realm Response DTO")
public class MixtureIngredientResponse extends BaseResponse {

  private RulesetResponse ruleset;

  private MixtureResponse mixture;

  private ItemResponse item;

  @Schema(
      description = "Quantity",
      name = "qty",
      type = "Integer",
      example = "1"
  )
  private Integer qty;
}
