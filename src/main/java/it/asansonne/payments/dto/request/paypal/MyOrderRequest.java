package it.asansonne.payments.dto.request.paypal;

import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.authhub.dto.Dto;
import it.asansonne.management.enumeration.AmountType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@MappedSuperclass
@RequiredArgsConstructor
public class MyOrderRequest implements Dto {
  @NotNull(message = "Amount type must be not null")
  @Schema(
      description = "Amount type",
      name = "amountType",
      type = "Enum",
      example = "AMOUNT_PG"
  )
  private AmountType amountType;
}
