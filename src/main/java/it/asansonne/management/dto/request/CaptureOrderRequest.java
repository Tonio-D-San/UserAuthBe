package it.asansonne.management.dto.request;

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
