//package it.asansonne.management.model;
//
//import it.asansonne.authhub.model.Models;
//import it.asansonne.management.enumeration.AbilityName;
//import it.asansonne.management.enumeration.AlchemicalMixturesType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
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
//@Table(name = "mixtures")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@EqualsAndHashCode
//@ToString
//public class Mixture implements Models {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id")
//  @ToString.Exclude
//  private Integer id;
//
//  @Column(name = "uuid", nullable = false, unique = true, columnDefinition = "UUID")
//  private UUID uuid;
//
//  @Column(name = "type")
//  private AlchemicalMixturesType type;
//
//  @Column(name = "name")
//  private String name;
//
//  @Column(name = "administration")
//  private String administration;
//
//  //TODO gestire una manyToMany tra effetti e ricette
//  @Column(name = "effect")
//  private List<Effect> effect;
//
//  //TODO gestire una oneToMany tra ingredienti e ricette
//  @Column(name = "recipes")
//  private List<Recipe> recipes;
//}
