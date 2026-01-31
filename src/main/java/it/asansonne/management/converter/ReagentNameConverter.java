package it.asansonne.management.converter;

import it.asansonne.management.enumeration.ReagentName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter()
public class ReagentNameConverter implements AttributeConverter<ReagentName, String> {

  @Override
  public String convertToDatabaseColumn(ReagentName attribute) {
    return attribute == null ? null : attribute.getName();
  }

  @Override
  public ReagentName convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    for (ReagentName value : ReagentName.values()) {
      if (dbData.equalsIgnoreCase(value.getName())) {
        return value;
      }
    }
    // Fallback: allow storing the enum name in DB as well
    try {
      return ReagentName.valueOf(dbData);
    } catch (Exception ignored) { //TODO da rivedere
      // ignore
    }
    throw new IllegalArgumentException("Unknown ReagentName: " + dbData);
  }
}
