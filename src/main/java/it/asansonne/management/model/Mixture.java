package it.asansonne.management.model;

import it.asansonne.common.ccsr.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(
    name = "mixtures",
    uniqueConstraints = @UniqueConstraint(name = "uq_mixtures_ruleset_code", columnNames = {
        "ruleset_id", "code"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Mixture extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ruleset_id", nullable = false)
  private Ruleset ruleset;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "alchemy_path_id", nullable = false)
  private AlchemyPath alchemyPath;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "tier", nullable = false)
  private String tier;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "produced_item_id", nullable = false)
  private Item producedItem;
}