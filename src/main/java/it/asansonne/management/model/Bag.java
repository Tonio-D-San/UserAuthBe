package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
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
  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Builder.Default
  @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Money> money = new ArrayList<>();

  @Builder.Default
  @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Reagent> reagents = new ArrayList<>();

  @OneToOne(mappedBy = "bag")
  private Character owner;
}
