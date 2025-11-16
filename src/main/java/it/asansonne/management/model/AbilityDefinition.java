package it.asansonne.management.model;

import it.asansonne.authhub.model.Models;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.enumeration.character.AbilityType;
import it.asansonne.management.enumeration.RequirementType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "ability_definition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbilityDefinition implements Models {

  @Id
  @Enumerated(EnumType.STRING)
  private AbilityName code;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String descriptionKey;

  @Enumerated(EnumType.STRING)
  private AbilityType type;

  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(
      name = "ability_definition_notes",
      joinColumns = @JoinColumn(name = "ability_definition_code", referencedColumnName = "code"),
      inverseJoinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id")
  )
  private List<Note> notes;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  private List<AbilityName> requirements;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  private List<AbilityName> unlockables;

  @Enumerated(EnumType.STRING)
  private RequirementType requirementType;
}

