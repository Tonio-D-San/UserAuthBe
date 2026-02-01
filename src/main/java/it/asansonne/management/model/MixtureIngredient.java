package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(
    name = "mixture_ingredients",
    uniqueConstraints = @UniqueConstraint(name = "uq_mixture_ingredient", columnNames = {
        "mixture_id", "item_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class MixtureIngredient extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "mixture_id", nullable = false)
  private Mixture mixture;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id", nullable = false)
  private Item item;

  @Column(name = "qty", nullable = false)
  private Integer qty;
}