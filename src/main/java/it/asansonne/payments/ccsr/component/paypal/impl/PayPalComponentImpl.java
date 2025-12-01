package it.asansonne.payments.ccsr.component.paypal.impl;

import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.PurchaseUnitRequest;
import it.asansonne.authhub.ccsr.component.users.UserComponent;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.authhub.exception.custom.IOCustomException;
import it.asansonne.payments.ccsr.component.paypal.PayPalComponent;
import it.asansonne.payments.dto.request.paypal.OrdersRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;
import it.asansonne.payments.model.MyOrder;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class PayPalComponentImpl implements PayPalComponent {
  private final PayPalHttpClient client;
  private final UserComponent userComponent;

  @Override
  public OrdersResponse findByUuid(UUID uuid) {
    return null;
  }

  @Override
  public Page<OrdersResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<OrdersResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return null;
  }

  @Override
  public Page<OrdersResponse> findAllByField(Pageable pageable, OrdersRequest request) {
    return null;
  }

  @Override
  public OrdersResponse findLastAdded() {
    return null;
  }

  @Override
  public void updateByUuid(UUID uuid, OrdersRequest request) {
    // TODO document why this method is empty
  }

  @Override
  public OrdersResponse create(Principal principal, OrdersRequest request) {
    OrdersCreateRequest createRequest = new OrdersCreateRequest();
    createRequest.header("prefer", "return=representation");
    createRequest.requestBody(buildRequestBody(
        String.valueOf(request.getAmountType().getValue()),
        request.getCurrencyCode().getCode()
    ));
    return this.createOrder(
        this.findUserFromPrincipal(principal),
        createRequest
    );
  }

  private OrderRequest buildRequestBody(String value, String code) {
    OrderRequest orderRequest = new OrderRequest();
    orderRequest.checkoutPaymentIntent("CAPTURE");
    orderRequest.applicationContext(new ApplicationContext()
        .brandName("IlTuoShop")
        .landingPage("NO_PREFERENCE")
        .cancelUrl("http://localhost:8082/error") //TODO cosa fare quando annulli il pagamento?
        .returnUrl("http://localhost:8082/login") //TODO cosa fare quando finisce il pagamento?
    );
    orderRequest.purchaseUnits(
        Collections.singletonList(
            new PurchaseUnitRequest()
                .referenceId("PU-" + System.currentTimeMillis())
                .amountWithBreakdown(new AmountWithBreakdown()
                    .currencyCode(code)
                    .value(value)
                )
        )
    );
    return orderRequest;
  }

  private OrdersResponse createOrder(UserResponse payer, OrdersCreateRequest request) {
    try {
      MyOrder order = MyOrder.from(client.execute(request).result());
      log.info("Order created: {}", order);
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
    return userComponent.findByUuid(
        UUID.fromString(principal.getName().split("[,\\[\\]\\s]+")[1])
    );
  }

}
