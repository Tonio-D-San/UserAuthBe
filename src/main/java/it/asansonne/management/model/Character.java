package it.asansonne.management.model;

import it.asansonne.common.ccsr.model.BaseModel;
import it.asansonne.authhub.model.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Character extends BaseModel {

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ruleset_id", nullable = false)
  private Ruleset ruleset;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "realm_id", nullable = false)
  private Realm realm;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "training_id")
  private Training training;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "pg_name", length = 50)
  private String pgName;

  @Column(name = "background")
  private String background;

  @ToString.Exclude
  @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CharacterAbility> abilities;

  @ToString.Exclude
  @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PointTransaction> pointTransactions;
}
