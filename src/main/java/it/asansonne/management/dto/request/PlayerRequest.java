package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.management.enumeration.character.Training;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
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
public class PlayerRequest implements Request {
  @NotBlank(message = "Player name")
  @Schema(
      description = "Player name",
      name = "name",
      type = "String",
      example = "mrossi"
  )
  private String name;

  @NotBlank(message = "Realm name must not be null or empty")
  @Schema(
      description = "Realm name for your PG",
      name = "realm",
      type = "RealmRequest",
      example = "realm: {CORONOR}")
  private RealmRequest realm;

  @NotBlank(message = "Backstory must not be null or empty")
  @Schema(
      description = "PG backstory",
      name = "background",
      type = "String",
      example = "This is my back story")
  private String background;

  @NotBlank(message = "Training must not be null or empty")
  @Schema(
      description = "PG training",
      name = "training",
      type = "Training",
      example = "EVALUATOR")
  private Training training;

  @NotBlank(message = "Abilities must not be null or empty")
  @Schema(
      description = "PG abilities",
      name = "abilities",
      type = "List<AbilityRequest>",
      example = "abilities: []")
  private List<AbilityRequest> abilities;

  @NotBlank(message = "Diary must not be null or empty")
  @Schema(
      description = "PG diary",
      name = "diaryRequests",
      type = "DiaryRequest>",
      example = "diaryRequests: {}}")
  private DiaryRequest diaryRequests;

  @NotBlank(message = "Images must not be null or empty")
  @Schema(
      description = "Your PG images",
      name = "images",
      type = "List<byte[]>")
  private List<byte[]> images;

}
