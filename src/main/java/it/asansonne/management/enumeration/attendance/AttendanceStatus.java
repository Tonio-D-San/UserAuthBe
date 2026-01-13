package it.asansonne.management.enumeration.attendance;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AttendanceStatus {
  PRESENT("present"),
  ABSENT("absent");

  private final String dbValue;
}
