package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "Representation of the Realm Request DTO")
public class ItemRequest implements Request {

  @NotNull(message = "The ruleset uuid must not be null")
  @Schema(
      description = "Ruleset uuid",
      name = "rulesetUuid",
      type = "UUID",
      example = "207db025-4e57-42c2-a710-42cc4354af18"
  )
  private UUID rulesetUuid;

  @NotBlank
  @Schema(
      description = "Codice tecnico stabile dell'item.",
      example = "POTION_HEALING_BASE"
  )
  private String code;

  @NotBlank
  @Schema(
      description = "Nome leggibile.",
      example = "Pozione di Cura (Base)"
  )
  private String name;

  @Schema(
      description = "Descrizione."
  )
  private String description;

  @NotNull
  @Schema(
      description = "Se true, l'item viene consumato all'uso.",
      example = "true"
  )
  private Boolean consumable;

  @NotNull
  @Schema(
      description = "Se true, può essere impilato (qty > 1).",
      example = "true"
  )
  private Boolean stackable;
}
