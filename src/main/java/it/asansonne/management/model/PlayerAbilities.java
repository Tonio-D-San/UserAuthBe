package it.asansonne.management.model;
//
//import it.asansonne.authhub.model.Models;
//import it.asansonne.management.enumeration.character.AbilityName;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
//import java.util.List;
//import java.util.UUID;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Builder
//@Entity
//@Table(name = "player_abilities")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@EqualsAndHashCode
//@ToString
//public class PlayerAbilities extends BaseModel {
//  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//  @JoinTable(name = "player_ability",
//      joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"),
//      inverseJoinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "id"))
//  private List<Ability> abilityName;
//
//  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//  @JoinTable(name = "player_ability",
//      joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"),
//      inverseJoinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "id"))
//  private List<Player> players;
//}
