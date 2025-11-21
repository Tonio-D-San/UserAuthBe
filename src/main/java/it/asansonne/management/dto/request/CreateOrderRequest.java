package it.asansonne.management.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CreateOrderRequest implements Dto {
  @NotNull(message = "Amount must be not null")
  @Schema(
      description = "Amount to be paid",
      name = "amount",
      type = "Integer",
      example = "10.00")
  private Integer amount;
}
