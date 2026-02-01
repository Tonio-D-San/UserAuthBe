package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(
    name = "alchemy_paths",
    uniqueConstraints = @UniqueConstraint(name = "uq_alchemy_paths_ruleset_code", columnNames = {
        "ruleset_id", "code"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class AlchemyPath extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ruleset_id", nullable = false)
  private Ruleset ruleset;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;
}