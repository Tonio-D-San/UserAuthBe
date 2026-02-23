package it.asansonne.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
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
public class BlogPostRequest extends BlogRequest {
  @Size(max = 1000, message = "Post excerpt must be at most 1000 characters")
  @Schema(
      description = "Short post excerpt/summary",
      name = "excerpt",
      type = "String",
      example = "Materiale e link per l'evento Memento.")
  private String excerpt;

  @Schema(
      description = "Cover image URL",
      name = "coverUrl",
      type = "String",
      example = "https://cdn.example.com/images/memento.jpg")
  private String coverUrl;

  @Size(max = 120, message = "Author name must be at most 120 characters")
  @Schema(
      description = "Author display name",
      name = "authorName",
      type = "String",
      example = "ALA Staff")
  private String authorName;

}
