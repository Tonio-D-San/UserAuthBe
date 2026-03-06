package it.asansonne.management.model;

import it.asansonne.common.ccsr.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(
    name = "ability_costs",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_ability_costs_ability_rank", columnNames = {"ability_id", "rank"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class AbilityCost extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ability_id", nullable = false)
  private Ability ability;

  @Column(name = "rank", nullable = false)
  private Integer rank;

  @Column(name = "cost", nullable = false)
  private Integer cost;
}
