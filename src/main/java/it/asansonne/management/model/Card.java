package it.asansonne.management.model;

import it.asansonne.authhub.model.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Card implements Models {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ToString.Exclude
  private Integer id;

  @Column(name = "uuid", nullable = false, unique = true, columnDefinition = "UUID")
  private UUID uuid;

  @Column(name = "total_points")
  private Integer totalPoints;

  @Column(name = "available_points")
  private Integer availablePoints;

  @Column(name = "used_points")
  private Integer usedPoints;

  @OneToOne(mappedBy = "kingdom")
  private Kingdom kingdom;

  @OneToOne(mappedBy = "card")
  private Player player;
}
