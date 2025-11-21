package it.asansonne.management.dto.response;

import com.paypal.orders.LinkDescription;
import com.paypal.orders.PurchaseUnit;
import it.asansonne.authhub.dto.Dto;
import it.asansonne.authhub.dto.response.UserResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OrdersCreateResponse implements Dto {
  private String orderId;
  private String checkoutPaymentIntent;
  private String createTime;
  private String expirationTime;
  private UserResponse payer;
  private String status;
  private String updateTime;
  private List<LinkDescription> links;
  private List<PurchaseUnit> purchaseUnits;
}
