package it.asansonne.blog.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.BaseResponse;
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
public abstract class BlogBaseResponse extends BaseResponse {
  @Schema(
      description = "Post slug",
      name = "slug",
      type = "String",
      example = "welcome-to-blog"
  )
  private String slug;
}
