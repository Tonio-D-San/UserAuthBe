package it.asansonne.diary.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
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
@Schema(description = "Representation of the Diary Request DTO")
public class DiaryRequest implements Request {
  @NotBlank(message = "Diary name")
  @Schema(
      description = "Diary name",
      name = "name",
      type = "String",
      example = "Titolo"
  )
  private String name;

  @NotBlank(message = "Realm name must not be null or empty")
  @Schema(
      description = "Current date in millis",
      name = "date",
      type = "Long",
      example = "1764584807785")
  private Long date;

  @NotBlank(message = "Backstory must not be null or empty")
  @Schema(
      description = "Diary description",
      name = "description",
      type = "String",
      example = "This is diary description")
  private String description;

  @Schema(
      description = "Diary images",
      name = "images",
      type = "List<byte[]>")
  private List<byte[]> images;

}
