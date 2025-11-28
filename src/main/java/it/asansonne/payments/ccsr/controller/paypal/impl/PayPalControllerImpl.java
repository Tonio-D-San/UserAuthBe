package it.asansonne.payments.ccsr.controller.paypal.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.management.enumeration.AmountType;
import it.asansonne.payments.ccsr.component.paypal.PayPalComponent;
import it.asansonne.payments.ccsr.controller.paypal.PayPalController;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;
import it.asansonne.payments.enumeration.CurrencyCode;
import java.security.Principal;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/payments")
@AllArgsConstructor
public class PayPalControllerImpl implements PayPalController {
  private final PayPalComponent payPalComponent;

  @PostMapping("/create-order")
  public OrdersResponse createOrder(
      Principal principal,
      @RequestParam(value = "amountType", defaultValue = "AMOUNT_PG") AmountType amountType,
      @RequestParam(value = "currencyCode", defaultValue = "EURO") CurrencyCode currencyCode
  ) {
    return payPalComponent.createOrder(principal, amountType, currencyCode);
  }

}
