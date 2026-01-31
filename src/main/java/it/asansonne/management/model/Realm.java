package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(
    name = "realms",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_realms_ruleset_name", columnNames = {"name"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Realm extends BaseModel {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "maxim", nullable = false)
  private String maxim;

  @ToString.Exclude
  @OneToMany(mappedBy = "realm")
  private List<Character> characters;
}
