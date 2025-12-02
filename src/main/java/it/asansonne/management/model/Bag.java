package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name = "bags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Bag extends BaseModel {
  @OneToMany(mappedBy = "bag")
  private List<Money> money;

  @OneToMany(mappedBy = "bag")
  private List<Reagent> reagents;

  @OneToOne(mappedBy = "bag")
  private Player owner;
}
