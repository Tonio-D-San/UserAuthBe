package it.asansonne.management.model;

import it.asansonne.authhub.model.Models;
import it.asansonne.authhub.model.jpa.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Player implements Models {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ToString.Exclude
  private Integer id;

  @Column(name = "uuid", nullable = false, unique = true, columnDefinition = "UUID")
  private UUID uuid;

  @Column(name = "pg_name", length = 50)
  private String pgName;

  @Column(name = "background")
  private String background;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Diary> diaries;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "card_id")
  private Card card;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "bag_id", nullable = false, unique = true)
  private Bag bag;

  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "player_ability",
      joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "id"))
  private List<Ability> abilities;
}
