package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.BaseResponse;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Training Request DTO")
public class TrainingResponse extends BaseResponse {

  private RulesetResponse ruleset;

  @Schema(
      description = "Training name",
      name = "name",
      type = "String",
      example = "Evaluate"
  )
  private String name;

  @Schema(
      description = "Training description",
      name = "description",
      type = "String",
      example = "Description of this training"
  )
  private String description;

  @Schema(
      description = "Character response",
      name = "characters",
      type = "CharacterResponse"
  )
  private List<CharacterResponse> characters;
}
