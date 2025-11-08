package it.asansonne.management.model;

import it.asansonne.management.enumeration.Call;
import it.asansonne.management.enumeration.Prefix;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@ToString
public class EffectKey implements Serializable {

  @Column(name = "prefix")
  @Enumerated(EnumType.STRING)
  private Prefix prefix;

  @Column(name = "call")
  @Enumerated(EnumType.STRING)
  private Call call;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof EffectKey that)) return false;
    return prefix == that.prefix && call == that.call;
  }

  @Override
  public int hashCode() {
    return Objects.hash(prefix, call);
  }
}
