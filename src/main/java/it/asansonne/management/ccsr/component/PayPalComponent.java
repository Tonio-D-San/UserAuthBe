package it.asansonne.management.ccsr.component;

import it.asansonne.management.dto.request.CreateOrderRequest;
import it.asansonne.management.dto.response.OrdersCreateResponse;
import java.security.Principal;

public interface PayPalComponent {
  OrdersCreateResponse createOrder(Principal principal, CreateOrderRequest request);
}
