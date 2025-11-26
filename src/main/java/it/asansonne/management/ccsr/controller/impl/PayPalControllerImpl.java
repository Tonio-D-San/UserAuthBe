package it.asansonne.management.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.management.ccsr.component.PayPalComponent;
import it.asansonne.management.ccsr.controller.PayPalController;
import it.asansonne.management.dto.request.MyOrderRequest;
import it.asansonne.management.dto.response.OrdersResponse;
import java.security.Principal;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/payments")
@AllArgsConstructor
public class PayPalControllerImpl implements PayPalController {
  private final PayPalComponent payPalComponent;

  @PostMapping("/create-order")
  public OrdersResponse createOrder(
      Principal principal,
      @RequestBody MyOrderRequest dto
  ) {
    return payPalComponent.createOrder(principal, dto);
  }

}
