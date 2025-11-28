package it.asansonne.payments.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CheckoutFlow {
  CONTINUE("Continue"),
  PAY_NOW("Pay Now");
  private final String flow;
}
