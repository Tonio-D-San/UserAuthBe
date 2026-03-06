package it.asansonne.management.model;

import it.asansonne.common.ccsr.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(
    name = "character_mixtures",
    uniqueConstraints = @UniqueConstraint(name = "uq_character_mixture", columnNames = {
        "character_id", "mixture_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CharacterMixture extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "character_id", nullable = false)
  private Character character;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "mixture_id", nullable = false)
  private Mixture mixture;

  @Column(name = "source_id", nullable = false)
  private Long sourceId;
}