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
    name = "ability_prerequisites",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_ability_prereq", columnNames = {"ability_id", "required_ability_id"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class AbilityPrerequisite extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ability_id", nullable = false)
  private Ability ability;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "required_ability_id", nullable = false)
  private Ability requiredAbility;

  @Column(name = "required_rank", nullable = false)
  private Integer requiredRank;
}
