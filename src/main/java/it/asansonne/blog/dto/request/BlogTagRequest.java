package it.asansonne.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.blog.validation.ValidBlogTagSelector;
import jakarta.validation.constraints.Size;
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
@Schema(description = "Representation of the Blog Request DTO")
@ValidBlogTagSelector
//@SlugMustBeAbsent
public class BlogTagRequest extends BlogBaseRequest {
  @Schema(
      description = "Blog tag uuid",
      name = "uuid",
      type = "UUID",
      example = "207db025-4e57-42c2-a710-42cc4354af18")
  private UUID uuid;

  @Size(min = 2, max = 120, message = "Tag name must be between 2 and 120 characters")
  @Schema(
      description = "Tag display name",
      name = "name",
      type = "String",
      example = "Eventi"
  )
  private String name;

}
