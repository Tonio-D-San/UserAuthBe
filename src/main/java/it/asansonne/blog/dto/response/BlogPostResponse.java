package it.asansonne.blog.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Character Request DTO")
public class BlogPostResponse extends BlogResponse {
  @Schema(
      description = "Blog excerpt",
      name = "excerpt",
      type = "String",
      example = "This is blog excerpt"
  )
  private String excerpt;

  @Schema(
      description = "Blog cover url",
      name = "coverUrl",
      type = "String",
      example = "This is blog coverUrl"
  )
  private String coverUrl;

  @Schema(
      description = "Blog authorName",
      name = "authorName",
      type = "String",
      example = "This is blog authorName"
  )
  private String authorName;

}
