package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(
    name = "mixture_effects",
    uniqueConstraints = @UniqueConstraint(name = "uq_mixture_effect", columnNames = {"mixture_id",
        "effect_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class MixtureEffect extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "mixture_id", nullable = false)
  private Mixture mixture;

  @Column(name = "effect_id", nullable = false)
  private Long effectId;

  @Column(name = "magnitude")
  private Integer magnitude;

  @Column(name = "duration_seconds")
  private Integer durationSeconds;
}