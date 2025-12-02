package it.asansonne.management.model;
//
//import it.asansonne.authhub.model.Models;
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
//@Table(name = "recipes")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@ToString
//public class Recipe extends BaseModel {
//  @Column(name = "name")
//  private String name;
//
//  //TODO gestire una manyToMany tra ricetta e ingredienti
//  @Column(name = "ingredients")
//  private List<Ingredient> ingredients;
//}
