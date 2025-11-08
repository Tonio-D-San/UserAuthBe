package it.asansonne.management.model;

import it.asansonne.management.enumeration.Call;
import it.asansonne.management.enumeration.Prefix;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EffectKey implements Serializable {

  @Column(name = "prefix")
  @Enumerated(EnumType.STRING)
  private Prefix prefix;

  @Column(name = "call")
  @Enumerated(EnumType.STRING)
  private Call call;

  public EffectKey() {}

  public EffectKey(Prefix prefix, Call call) {
    this.prefix = prefix;
    this.call = call;
  }

  // equals e hashCode
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
