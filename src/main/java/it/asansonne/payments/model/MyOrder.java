package it.asansonne.payments.model;

import com.paypal.orders.Order;
import it.asansonne.authhub.model.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyOrder extends Order implements Models {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ToString.Exclude
  private String orderId;

  @Column(name = "uuid", nullable = false, unique = true, columnDefinition = "UUID")
  private UUID uuid;

  public MyOrder(Order o) {
    super.checkoutPaymentIntent(o.checkoutPaymentIntent());
    super.createTime(o.createTime());
    super.expirationTime(o.expirationTime());
    this.setOrderId(o.id());
    super.links(o.links());
    super.payer(o.payer());
    super.purchaseUnits(o.purchaseUnits());
    super.status(o.status());
    super.updateTime(o.updateTime());
    this.uuid = UUID.randomUUID();
  }

  public static MyOrder from(Order o) {
    return new MyOrder(o);
  }
}
