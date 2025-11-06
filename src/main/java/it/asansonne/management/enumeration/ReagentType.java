package it.asansonne.management.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReagentType {
  GENERIC("Abilità generiche"),
  ALCHEMY("Abilità alchemiche"),
  EXTRACTION("Abilità estrattive"),
  CRAFTSMANSHIP("Abilità di artigianato"),
  COMBAT("Abilità di combattimento"),
  RECOVERY("Abilità di guarigione"),
  MAGIC("Abilità di magia"),
  RITUALIST("Abilità da ritualista"),
  YIELD("Abilità da Rendita")
  ;

  private final String name;
}
