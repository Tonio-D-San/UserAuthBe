package it.asansonne.management.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import jakarta.validation.constraints.NotBlank;
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
public class RealmRequest implements Request {
  @NotBlank
  @Schema(
      description = "Realm name",
      example = "Coronor"
  )
  private String name;

  @Schema(
      description = "Descrizione del realm",
      example = "Realm di Coronor",
      hidden = true
  )
  private String description;

  private String maxim;
}
