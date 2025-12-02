package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@ToString
public class Card extends BaseModel {
  @Column(name = "total_points")
  private Integer totalPoints;

  @Column(name = "available_points")
  private Integer availablePoints;

  @Column(name = "used_points")
  private Integer usedPoints;

  @OneToOne(mappedBy = "card")
  private Player player;
}
