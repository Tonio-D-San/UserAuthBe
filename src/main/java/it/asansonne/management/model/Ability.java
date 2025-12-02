package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import it.asansonne.management.enumeration.RequirementType;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.enumeration.character.AbilityType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
@Table(name = "ability")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ability extends BaseModel {
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
      name = "ability_notes",
      joinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id")
  )
  private List<Note> notes;

  @ManyToMany
  @JoinTable(
      name = "ability_requirements",
      joinColumns = @JoinColumn(name = "ability_id"),
      inverseJoinColumns = @JoinColumn(name = "requirement_id")
  )
  private List<Ability> requirements;

  @ManyToMany(mappedBy = "requirements")
  private List<Ability> unlockables;

  @Enumerated(EnumType.STRING)
  private RequirementType requirementType;

  @ManyToMany(mappedBy = "abilities")
  private List<Player> players;

}

