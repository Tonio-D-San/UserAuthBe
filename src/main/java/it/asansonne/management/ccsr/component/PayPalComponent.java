package it.asansonne.management.ccsr.component;

import it.asansonne.management.dto.request.MyOrderRequest;
import it.asansonne.management.dto.response.OrdersResponse;
import java.security.Principal;

public interface PayPalComponent {
  OrdersResponse createOrder(Principal principal, MyOrderRequest request);
}
