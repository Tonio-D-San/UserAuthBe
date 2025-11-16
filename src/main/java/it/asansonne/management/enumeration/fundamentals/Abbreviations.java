package it.asansonne.management.enumeration.fundamentals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Abbreviations {
  PS("Punti scheda"),
  GRV("Gioco di ruolo dal vivo"),
  PV("Punti vita"),
  CA("Categoria armatura"),
  PA("Punti armatura"),
  PG("Personaggio giocante"),
  PNG("Personaggio non giocante"),
  GM("Master di gioco")
  ;
  private final String abbreviation;
}
