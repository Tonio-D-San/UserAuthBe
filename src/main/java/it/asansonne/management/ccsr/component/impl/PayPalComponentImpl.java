package it.asansonne.management.ccsr.component.impl;

import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.PurchaseUnitRequest;
import it.asansonne.authhub.ccsr.component.UserComponent;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.custom.IOCustomException;
import it.asansonne.management.ccsr.component.PayPalComponent;
import it.asansonne.management.dto.request.CreateOrderRequest;
import it.asansonne.management.dto.response.OrdersCreateResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PayPalComponentImpl implements PayPalComponent {
  private final PayPalHttpClient client;
  private final UserComponent userComponent;

  public OrdersCreateResponse createOrder(Principal principal, CreateOrderRequest dto) {
    OrdersCreateRequest request = new OrdersCreateRequest();
    request.header("prefer", "return=representation");
    request.requestBody(buildRequestBody(dto));
    try {
      Order order = client.execute(request).result();
      return OrdersCreateResponse.builder()
          .orderId(order.id())
          .checkoutPaymentIntent(order.checkoutPaymentIntent())
          .createTime(order.createTime())
          .expirationTime(order.expirationTime())
          .payer(this.findUserFromPrincipal(principal))
          .status(order.status())
          .updateTime(order.updateTime())
          .links(order.links())
          .purchaseUnits(order.purchaseUnits())
          .build();
    } catch (IOException _) {
      throw new IOCustomException("Error creating order");
    }
  }

  private OrderRequest buildRequestBody(CreateOrderRequest dto) {
    OrderRequest orderRequest = new OrderRequest();
    orderRequest.checkoutPaymentIntent("CAPTURE");
    orderRequest.applicationContext(new ApplicationContext()
        .brandName("IlTuoShop")
        .landingPage("NO_PREFERENCE")
        .cancelUrl("http://localhost:8082/login")
        .returnUrl("http://localhost:8082/login"));
    orderRequest.purchaseUnits(Collections.singletonList(new PurchaseUnitRequest()
        .referenceId("PU-" + System.currentTimeMillis())
        .amountWithBreakdown(new AmountWithBreakdown()
            .currencyCode("EUR")
            .value(String.valueOf(dto.getAmount()))
        )
    ));
    return orderRequest;
  }

  private UserResponse findUserFromPrincipal(Principal principal) {
    return userComponent.findUserByUuid(
        UUID.fromString(principal.getName().split("[,\\[\\]\\s]+")[1])
    );
  }
}
