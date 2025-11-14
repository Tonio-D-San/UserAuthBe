package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayPalType {
  LIVE("live"),
  SANDBOX("sandbox");
  private final String type;
}
