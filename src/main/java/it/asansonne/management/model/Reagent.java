package it.asansonne.management.model;

import it.asansonne.authhub.model.Models;
import it.asansonne.management.enumeration.ReagentName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name = "reagents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Reagent implements Models {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ToString.Exclude
  private Integer id;

  @Column(name = "uuid", nullable = false, unique = true, columnDefinition = "UUID")
  private UUID uuid;

  @Column(name = "reagent_name", length = 50)
  private ReagentName reagentName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bag_id", nullable = false)
  private Bag bag;
}
