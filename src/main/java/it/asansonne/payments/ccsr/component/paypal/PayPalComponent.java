package it.asansonne.payments.ccsr.component.paypal;

import it.asansonne.management.enumeration.AmountType;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;
import it.asansonne.payments.enumeration.CurrencyCode;
import java.security.Principal;

public interface PayPalComponent {
  OrdersResponse createOrder(Principal principal, AmountType amountType, CurrencyCode currencyCode);
}
