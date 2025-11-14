package it.asansonne.management.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCaptureRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.PurchaseUnitRequest;
import it.asansonne.management.ccsr.controller.PayPalController;
import it.asansonne.management.dto.request.CaptureOrderRequest;
import it.asansonne.management.dto.request.CreateOrderRequest;
import it.asansonne.management.dto.response.CreateOrderResponse;
import java.io.IOException;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/payments")
@AllArgsConstructor
public class PayPalControllerImpl implements PayPalController {
  private final PayPalHttpClient client;

  @PostMapping("/create-order")
  public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest dto) throws IOException {
    OrdersCreateRequest request = new OrdersCreateRequest();
    request.header("prefer","return=representation");
    request.requestBody(buildRequestBody(dto));

    HttpResponse<Order> response = client.execute(request);
    Order order = response.result();
    return ResponseEntity.ok(new CreateOrderResponse(order.id()));
  }

  private OrderRequest buildRequestBody(CreateOrderRequest dto) {
    OrderRequest orderRequest = new OrderRequest();
    orderRequest.checkoutPaymentIntent("CAPTURE");
    ApplicationContext appContext = new ApplicationContext()
        .brandName("IlTuoShop")
        .landingPage("NO_PREFERENCE")
        .cancelUrl("http://localhost:8082/login")
        .returnUrl("http://localhost:8082/login");
    orderRequest.applicationContext(appContext);

    PurchaseUnitRequest unit = new PurchaseUnitRequest()
        .referenceId("PU-" + System.currentTimeMillis())
        .amountWithBreakdown(new AmountWithBreakdown().currencyCode("EUR").value(dto.getAmount()));

    orderRequest.purchaseUnits(Collections.singletonList(unit));
    return orderRequest;
  }

  @PostMapping("/capture-order")
  public ResponseEntity<?> captureOrder(@RequestBody CaptureOrderRequest dto) throws IOException {
    OrdersCaptureRequest request = new OrdersCaptureRequest(dto.getOrderId());
    request.requestBody(new OrderRequest());
    HttpResponse<Order> response = client.execute(request);
    Order order = response.result();
    return ResponseEntity.ok(order);
  }

}
