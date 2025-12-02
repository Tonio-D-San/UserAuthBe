package it.asansonne.payments.model;

import com.paypal.orders.Order;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderWrapper {
  @Transient
  private Order order;

}
