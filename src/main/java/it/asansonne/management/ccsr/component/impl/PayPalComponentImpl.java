package it.asansonne.management.ccsr.component.impl;

import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.PurchaseUnitRequest;
import it.asansonne.authhub.ccsr.component.UserComponent;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.custom.IOCustomException;
import it.asansonne.management.ccsr.component.PayPalComponent;
import it.asansonne.management.dto.request.MyOrderRequest;
import it.asansonne.management.dto.response.OrdersResponse;
import it.asansonne.management.mapper.impl.OrderMapper;
import it.asansonne.management.model.MyOrder;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class PayPalComponentImpl implements PayPalComponent {
  private final PayPalHttpClient client;
  private final UserComponent userComponent;
  private final OrderMapper orderMapper;

  public OrdersResponse createOrder(Principal principal, MyOrderRequest dto) {
    OrdersCreateRequest request = new OrdersCreateRequest();
    request.header("prefer", "return=representation");
    request.requestBody(buildRequestBody(dto.getAmountType().getValue()));
    return this.createOrder(
        this.findUserFromPrincipal(principal),
        request
    );
  }

  private OrderRequest buildRequestBody(Integer amount) {
    OrderRequest orderRequest = new OrderRequest();
    orderRequest.checkoutPaymentIntent("CAPTURE");
    orderRequest.applicationContext(new ApplicationContext()
        .brandName("IlTuoShop")
        .landingPage("NO_PREFERENCE")
        .cancelUrl("http://localhost:8082/login") //TODO cosa fare quando annulli il pagamento?
        .returnUrl("http://localhost:8082/login")); //TODO cosa fare quando finisce il pagamento?
    orderRequest.purchaseUnits(
        Collections.singletonList(
            new PurchaseUnitRequest()
                .referenceId("PU-" + System.currentTimeMillis())
                .amountWithBreakdown(new AmountWithBreakdown()
                    .currencyCode("EUR")
                    .value(String.valueOf(amount))
                )
        )
    );
    return orderRequest;
  }

  private OrdersResponse createOrder(UserResponse payer, OrdersCreateRequest request) {
    try {
      MyOrder order = MyOrder.from(client.execute(request).result());
      log.info("Order created: {}", order);
      orderMapper.toDto(order);
      return OrdersResponse.builder()
          .orderId(order.id())
          .checkoutPaymentIntent(order.checkoutPaymentIntent())
          .createTime(order.createTime())
          .expirationTime(order.expirationTime())
          .payer(payer)
          .status(order.status())
          .updateTime(order.updateTime())
          .links(order.links())
          .purchaseUnits(order.purchaseUnits())
          .build();
    } catch (IOException _) {
      throw new IOCustomException("Error creating order");
    }
  }
  private UserResponse findUserFromPrincipal(Principal principal) {
    return userComponent.findUserByUuid(
        UUID.fromString(principal.getName().split("[,\\[\\]\\s]+")[1])
    );
  }
}
