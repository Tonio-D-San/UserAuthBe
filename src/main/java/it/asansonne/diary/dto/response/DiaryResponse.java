package it.asansonne.diary.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
import it.asansonne.diary.model.DiaryEntry;
import it.asansonne.management.dto.response.CharacterResponse;
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
@Schema(description = "Representation of the Character Request DTO")
public class DiaryResponse extends BaseResponse {
  @Schema(
      description = "Character name",
      name = "name",
      type = "String",
      example = "mrossi"
  )
  private String name;

  @Schema(
      description = "Realm response",
      name = "realm",
      type = "RealmResponse",
      example = "Coronor")
  private List<DiaryEntry> entries;

  @Schema(
      description = "Character response",
      name = "character",
      type = "CharacterResponse",
      example = "character: {}")
  private CharacterResponse character;
}
