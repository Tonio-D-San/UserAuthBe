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
import org.hibernate.annotations.DynamicInsert;

@Builder
@DynamicInsert
@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Card extends BaseModel {

  @Builder.Default
  @Column(name = "total_points", nullable = false)
  private Integer totalPoints = 0;

  @Builder.Default
  @Column(name = "available_points", nullable = false)
  private Integer availablePoints = 0;

  @Builder.Default
  @Column(name = "used_points", nullable = false)
  private Integer usedPoints = 0;

  @OneToOne(mappedBy = "card")
  private Character character;

  public void prePersistCard() {
    if (totalPoints == null) {
      totalPoints = 0;
    }
    if (availablePoints == null) {
      availablePoints = 0;
    }
    if (usedPoints == null) {
      usedPoints = 0;
    }
  }
}
