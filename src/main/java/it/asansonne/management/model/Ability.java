package it.asansonne.management.model;

import it.asansonne.common.ccsr.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;
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
    name = "abilities",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_abilities_ruleset_code", columnNames = {"ruleset_id", "code"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Ability extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ruleset_id", nullable = false)
  private Ruleset ruleset;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "is_repeatable", nullable = false)
  private Boolean isRepeatable;

  @Column(name = "max_rank")
  private Integer maxRank;

  @ToString.Exclude
  @OneToMany(mappedBy = "ability", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AbilityCost> costs;

  // prerequisiti “che io richiedo”
  @ToString.Exclude
  @OneToMany(mappedBy = "ability", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AbilityPrerequisite> prerequisites;

  // prerequisiti “in cui io sono richiesto da altri”
  // NIENTE cascade/orphanRemoval qui: è “vista inversa”, non ownership.
  @ToString.Exclude
  @OneToMany(mappedBy = "requiredAbility")
  private List<AbilityPrerequisite> requiredBy;
}
