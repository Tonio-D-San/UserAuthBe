package it.asansonne.management.dto.response;

import it.asansonne.authhub.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CreateOrderResponse implements Dto {
  private String orderId;
}
