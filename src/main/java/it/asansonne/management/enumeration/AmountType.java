package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AmountType {
  AMOUNT_PG( "amount_pg.name", "amount_pg.description", 15),
  AMOUNT_PNG("amount_png.name", "amount_png.description", 10),
  AMOUNT_MEMBERSHIP("amount_membership.name", "amount_membership.description", 20)
  ;

  private final String name;
  private final String description;
  private final Integer value;
}
