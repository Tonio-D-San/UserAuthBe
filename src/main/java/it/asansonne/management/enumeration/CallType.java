package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CallType implements Name{
  PHYSICAL("call_type.physic.name"),
  ALCHEMIC("call_type.alchemic.name"),
  NOT_RESISTIBLE("call_type.not_resistible.name"),
  UNKNOWN("call_type.unknown.name")
  ;

  private final String name;
}
