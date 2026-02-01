package it.asansonne.management.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
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
@Schema(description = "Representation of the Realm Response DTO")
public class RealmResponse extends BaseResponse {

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
      description = "Realm maxim",
      name = "maxim",
      type = "String",
      example = "This realm is the best"
  )
  private String maxim;


  @Schema(
      description = "Character response",
      name = "characters",
      type = "CharacterResponse"
  )
  private List<CharacterResponse> characters;
}
