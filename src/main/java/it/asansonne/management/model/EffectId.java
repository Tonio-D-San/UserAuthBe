package it.asansonne.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EffectId implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Column(name = "prefix", nullable = false, length = 255)
  private String prefix;

  @Column(name = "call", nullable = false, length = 255)
  private String call;
}
