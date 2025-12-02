package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import it.asansonne.management.enumeration.ReagentName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "reagents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Reagent extends BaseModel {
  @Column(name = "reagent_name", length = 50)
  @Enumerated(EnumType.STRING)
  private ReagentName reagentName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bag_id", nullable = false)
  private Bag bag;
}
