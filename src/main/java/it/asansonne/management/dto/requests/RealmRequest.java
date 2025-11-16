package it.asansonne.management.dto.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import it.asansonne.management.enumeration.character.RealmName;
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
  @NotBlank(message = "Realm name must not be null or empty")
  @Schema(
      description = "Realm name",
      name = "Realm",
      type = "Enum",
      example = "Coronor")
  private RealmName realmName;
}
