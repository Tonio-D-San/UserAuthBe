package it.asansonne.authhub.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupName {
  ALA("ala-users"),
  ADMIN("admin"),
  MASTERS("masters"),
  TEAM_SOCIAL("team-social"),
  COMMUNITY("community"),
  PNG("png"),
  PG("pg"),
  CORONOR("coronor"),
  LEVALIA("levalia"),
  MALATEA("malatea"),
  TAL_MERIDIA("tal-meridia"),
  VALMORA("valmora")
  ;

  private final String name;
}
