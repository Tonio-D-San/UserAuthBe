package it.asansonne.management.enumeration.attendance;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardTransactionSource {
  EVENT_DAY("event_day");

  private final String dbValue;
}
