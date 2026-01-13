package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.management.enumeration.character.Training;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "Representation of the Character Request DTO")
public class CharacterRequest implements Request {
  @NotBlank(message = "Character name")
  @Schema(
      description = "Character name",
      name = "name",
      type = "String",
      example = "mrossi"
  )
  private String name;

  @NotNull(message = "Realm name must not be null or empty")
  @Schema(
      description = "Realm name for your PG",
      name = "realm",
      type = "RealmRequest")
  private RealmRequest realm;

  @NotBlank(message = "Backstory must not be null or empty")
  @Schema(
      description = "PG backstory",
      name = "background",
      type = "String",
      example = "This is my back story")
  private String background;

  @NotNull(message = "Training must not be null")
  @Schema(
      description = "PG training",
      name = "training",
      type = "Training",
      example = "EVALUATOR")
  private Training training;

  @Valid
  @NotNull(message = "Abilities must not be null")
  @Schema(
      description = "PG abilities",
      name = "abilities",
      type = "List<AbilityRequest>"
  )
  private List<AbilityRequest> abilities;

  @Valid
  @NotNull(message = "Card must not be null")
  @Schema(
      description = "PG card (points management)",
      name = "card",
      type = "CardRequest")
  private CardRequest card;

  @Valid
  @Schema(
      description = "PG bag (inventory)",
      name = "bag",
      type = "BagRequest")
  private BagRequest bag;

  @Valid
  @NotNull(message = "Card must not be null")
  @Schema(
      description = "PG diary",
      name = "diaryRequests",
      type = "List<DiaryRequest>",
      hidden = true
  )
  private List<DiaryRequest> diaryRequests;

}
