package it.asansonne.management.model;

import it.asansonne.authhub.model.Models;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "effects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Effect implements Models {

  @EmbeddedId
  private EffectId id;

  @Column(name = "duration")
  private Long duration;

  @Column(name = "uuid", nullable = false, unique = true, columnDefinition = "UUID")
  private UUID uuid;

  @Column(name = "created_at", nullable = false, updatable = false)
  private Long createdAt;

  @Column(name = "updated_at", nullable = false)
  private Long updatedAt;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive = true;

  @PrePersist
  public void prePersist() {
    if (uuid == null) {
      uuid = UUID.randomUUID();
    }
    if (isActive == null) {
      isActive = true;
    }
  }
}
