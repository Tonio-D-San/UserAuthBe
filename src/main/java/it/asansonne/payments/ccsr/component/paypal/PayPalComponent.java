package it.asansonne.payments.ccsr.component.paypal;

import it.asansonne.payments.dto.request.paypal.MyOrderRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;
import java.security.Principal;

public interface PayPalComponent {
  OrdersResponse createOrder(Principal principal, MyOrderRequest request);
}
