package it.asansonne.payments.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyOrder extends BaseModel {
  @Embedded
  private OrderWrapper orderWrapper;
}
