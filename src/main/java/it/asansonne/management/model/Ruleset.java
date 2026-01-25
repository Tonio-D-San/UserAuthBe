package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    name = "rulesets",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_rulesets_name", columnNames = "name")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Ruleset extends BaseModel {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "initial_points", nullable = false)
  private Integer initialPoints;

  @Column(name = "required_spend_points", nullable = false)
  private Integer requiredSpendPoints;

  @Column(name = "max_points_at_creation")
  private Integer maxPointsAtCreation;

  @ToString.Exclude
  @OneToMany(mappedBy = "ruleset", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Realm> realms;

  @ToString.Exclude
  @OneToMany(mappedBy = "ruleset", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Ability> abilities;

  @ToString.Exclude
  @OneToMany(mappedBy = "ruleset", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Training> trainings;

  @ToString.Exclude
  @OneToMany(mappedBy = "ruleset")
  private List<Character> characters;
}
