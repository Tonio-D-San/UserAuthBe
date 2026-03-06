package it.asansonne.payments.dto.request.paypal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import it.asansonne.common.dto.Request;
import it.asansonne.management.enumeration.AmountType;
import it.asansonne.payments.enumeration.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Representation of the Ability Request DTO")
public class OrdersRequest implements Request {
  AmountType amountType;
  CurrencyCode currencyCode;
}
