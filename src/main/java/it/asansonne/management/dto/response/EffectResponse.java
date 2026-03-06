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
@Schema(description = "Representation of the Realm Response DTO")
public class EffectResponse extends BaseResponse {

  private RulesetResponse ruleset;

  @Schema(
      description = "Realm name",
      name = "name",
      type = "String",
      example = "Coronor"
  )
  private String name;

  @Schema(
      description = "Realm description",
      name = "description",
      type = "String",
      example = "Description of this realm"
  )
  private String description;

  @Schema(
      description = "Effect code",
      name = "code",
      type = "String",
      example = "Code"
  )
  private String code;

  @Schema(
      description = "Effect description",
      type = "Boolean",
      example = "true"
  )
  private Boolean isActive;
}
