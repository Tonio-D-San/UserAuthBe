package it.asansonne.authhub.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The type Group response.
 */
@SuperBuilder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Group Response DTO")
public class GroupResponse extends BaseResponse {
  @JsonProperty("name")
  @Schema(
      description = "Category name",
      name = "name",
      type = "String",
      example = "Java")
  private String name;

  @JsonProperty("path")
  @Schema(
      description = "Category path",
      name = "path",
      type = "String",
      example = "/application-users/admin-service-administrators")
  private String path;
}
