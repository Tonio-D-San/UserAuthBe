package it.asansonne.payments.ccsr.controller.paypal.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.payments.ccsr.component.paypal.PayPalComponent;
import it.asansonne.payments.ccsr.controller.paypal.PayPalController;
import it.asansonne.payments.dto.request.paypal.OrdersRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;
import java.security.Principal;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/payments")
@AllArgsConstructor
public class PayPalControllerImpl implements PayPalController {
  private final PayPalComponent payPalComponent;

  @Override
  public ResponseEntity<OrdersResponse> create(
      Principal principal,
      OrdersRequest request,
      UriComponentsBuilder builder
  ) {
    OrdersResponse response = payPalComponent.createOrder(principal, request);
    return ResponseEntity
        .created(builder
            .path(API + "/" + API_VERSION + "/payments")
            .buildAndExpand(response.getOrderId())
            .toUri()
        ).body(response);
  }
}
