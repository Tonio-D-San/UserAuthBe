package it.asansonne.management.model;
//
//import it.asansonne.authhub.model.Models;
//import it.asansonne.management.enumeration.OriginType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
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
//@Table(name = "ingredients")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@ToString
//public class Ingredient extends BaseModel {
//  @Column(name = "name")
//  private String name;
//
//  @Column(name = "quantity")
//  private Integer quantity;
//
//  @Column(name = "origin")
//  @Enumerated(EnumType.STRING)
//  private OriginType origin;
//}
