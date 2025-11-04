package it.asansonne.management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AbilityDefinitionDTO {
  private String code;
  private String name;
  private String description;
  private String type;
  private String requirementType;
}

