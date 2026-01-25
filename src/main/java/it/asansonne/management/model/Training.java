package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
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
    name = "trainings",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_trainings_ruleset_name", columnNames = {"ruleset_id", "name"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Training extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ruleset_id", nullable = false)
  private Ruleset ruleset;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @ToString.Exclude
  @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TrainingAbilityGrant> abilityGrants;

  @ToString.Exclude
  @OneToMany(mappedBy = "training")
  private List<Character> characters;
}
