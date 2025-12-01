package it.asansonne.diary.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Response;
import it.asansonne.diary.model.DiaryEntry;
import it.asansonne.management.dto.response.PlayerResponse;
import java.util.List;
import java.util.UUID;
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
@Schema(description = "Representation of the Player Request DTO")
public class DiaryResponse implements Response {
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @Schema(
      description = "Player uuid",
      name = "uuid",
      type = "UUID",
      example = "08fba211-60ca-45fc-b809-86bc2ad81dca")
  private UUID uuid;

  @Schema(
      description = "Player name",
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
      description = "Player response",
      name = "player",
      type = "PlayerResponse",
      example = "player: {}")
  private PlayerResponse player;
}
