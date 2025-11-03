package it.asansonne.management.model;

import it.asansonne.management.enumeration.AbilityName;
import it.asansonne.management.enumeration.AbilityType;
import it.asansonne.management.enumeration.RequirementType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "ability_definitions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbilityDefinition {

  @Id
  @Enumerated(EnumType.STRING)
  private AbilityName code;

  @Column(nullable = false)
  private String nameKey; // es. "cartographer.name"

  @Column(nullable = false)
  private String descriptionKey; // es. "cartographer.description"

  @Enumerated(EnumType.STRING)
  private AbilityType type;

  @ElementCollection
  private List<String> noteKeys;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  private List<AbilityName> requirements;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  private List<AbilityName> unlockables;

  @Enumerated(EnumType.STRING)
  private RequirementType requirementType;
}

