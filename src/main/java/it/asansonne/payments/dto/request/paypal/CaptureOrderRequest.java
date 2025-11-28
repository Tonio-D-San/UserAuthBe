package it.asansonne.payments.dto.request.paypal;

import it.asansonne.authhub.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CaptureOrderRequest implements Dto {
  private String orderId;
}
