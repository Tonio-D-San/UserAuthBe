package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import it.asansonne.authhub.model.users.User;
import it.asansonne.diary.model.Diary;
import it.asansonne.management.enumeration.character.Training;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Character extends BaseModel {
  @Column(name = "pg_name", length = 50)
  private String pgName;

  @Column(name = "background")
  private String background;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Diary> diaries;

  @Column(name = "training")
  @Enumerated(EnumType.STRING)
  private Training training;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "realm_id", nullable = false)
  private Realm realm;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "card_id")
  private Card card;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "bag_id", nullable = false, unique = true)
  private Bag bag;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "character_ability",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "ability_id")
  )
  private List<Ability> abilities;
}
