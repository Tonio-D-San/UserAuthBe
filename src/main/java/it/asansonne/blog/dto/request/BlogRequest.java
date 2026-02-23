package it.asansonne.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
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
public abstract class BlogRequest extends BlogBaseRequest {
  @NotBlank(message = "Post title must not be null or empty")
  @Size(min = 3, max = 200, message = "Post title must be between 3 and 200 characters")
  @Schema(
      description = "Post title",
      name = "title",
      type = "String",
      example = "Memento")
  private String title;

  @NotBlank(message = "Post content must not be null or empty")
  @Schema(
      description = "Post content in Markdown",
      name = "contentMd",
      type = "String",
      example = "### Guida all’evento\n- [Guida](https://example.com)\n")
  private String contentMd;

  @NotNull(message = "Page statusRequest must not be null")
  @Valid
  @Schema(
      description = "Status of post",
      type = "BlogStatusRequest",
      nullable = true
  )
  private BlogStatusRequest statusRequest;

  @Valid
  @Schema(
      description = "List of tags",
      name = "tags",
      type = "List<BlogTagRequest>"
  )
  private List<BlogTagRequest> tags;

}
