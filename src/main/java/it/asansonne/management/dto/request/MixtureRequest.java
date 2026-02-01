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
@Schema(description = "Representation of the Mixture Request DTO")
public class MixtureRequest implements Request {
  @NotNull
  @Schema(
      description = "UUID del ruleset proprietario."
  )
  private UUID rulesetUuid;

  @NotNull
  @Schema(
      description = "UUID della Via (alchemy path) a cui appartiene la mistura."
  )
  private UUID alchemyPathUuid;

  @NotNull
  @Schema(
      description = "UUID dell'item prodotto quando la ricetta viene creata/usata."
  )
  private UUID producedItemUuid;

  @NotBlank
  @Schema(
      description = "Codice tecnico stabile.",
      example = "MIXTURE_CARTOGRAFICA_01"
  )
  private String code;

  @NotBlank
  @Schema(
      description = "Nome leggibile.",
      example = "Infuso del Cartografo"
  )
  private String name;

  @Schema(
      description = "Descrizione."
  )
  private String description;

  @NotBlank
  @Schema(
      description = "Tier della mistura (es: BASE, APPRENDISTA, ESPERTO).",
      example = "BASE"
  )
  private String tier;
}
