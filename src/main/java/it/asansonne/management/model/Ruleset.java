package it.asansonne.management.model;

import it.asansonne.common.ccsr.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.UUID;
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
    name = "rulesets",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_rulesets_code_version",
            columnNames = {"code", "version"}
        )
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Ruleset extends BaseModel {

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "version", nullable = false)
  private Integer version;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "previous_ruleset_uuid")
  private UUID previousRulesetUuid;

  @Column(name = "published_at")
  private Long publishedAt;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "initial_points", nullable = false)
  private Integer initialPoints;

  @Column(name = "required_spend_points", nullable = false)
  private Integer requiredSpendPoints;

  @Column(name = "max_points_at_creation")
  private Integer maxPointsAtCreation;
}
