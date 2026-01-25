package it.asansonne.payments.dto.response.paypal;

import com.paypal.orders.LinkDescription;
import com.paypal.orders.PurchaseUnit;
import it.asansonne.authhub.dto.BaseResponse;
import it.asansonne.authhub.dto.response.UserResponse;
import java.util.List;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class OrdersResponse extends BaseResponse {
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
