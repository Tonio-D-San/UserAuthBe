package it.asansonne.blog.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
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
public abstract class BlogResponse extends BlogBaseResponse {
  @Schema(
      description = "Post title",
      name = "title",
      type = "String",
      example = "Title"
  )
  private String title;

  @Schema(
      description = "Blog contentMd",
      name = "contentMd",
      type = "String",
      example = "This is blog contentMd"
  )
  private String contentMd;

  @Schema(
      description = "Published at",
      name = "publishedAt",
      type = "Long",
      example = "1769300745474"
  )
  private Long publishedAt;

  @Schema(
      description = "List of tags",
      name = "tags",
      type = "List<BlogTagResponse>"
  )
  private List<BlogTagResponse> tags;
}
