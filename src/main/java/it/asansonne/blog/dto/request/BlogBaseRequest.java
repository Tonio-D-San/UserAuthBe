package it.asansonne.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Blog Request DTO")
public abstract class BlogBaseRequest implements Request {
  @NotBlank(message = "Post slug must not be null or empty")
  @Size(min = 3, max = 200, message = "Post slug must be between 3 and 200 characters")
  @Pattern(
      regexp = "^(?!-)(?!.*--)[a-z0-9-]+(?<!-)$",
      message = "Post slug must be URL-safe (lowercase, numbers, hyphen). Example: memento-evento-2026"
  )
  @Schema(
      description = "Post slug (URL-safe identifier)",
      name = "slug",
      type = "String",
      example = "memento")
  private String slug;

}
