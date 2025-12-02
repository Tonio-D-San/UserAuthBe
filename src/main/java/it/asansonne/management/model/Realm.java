package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import it.asansonne.management.enumeration.character.RealmName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "realms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Realm extends BaseModel {
  @Column(name = "realm_name", length = 50)
  @Enumerated(EnumType.STRING)
  private RealmName realmName;

}
