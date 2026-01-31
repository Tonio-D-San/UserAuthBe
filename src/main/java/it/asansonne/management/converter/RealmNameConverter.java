package it.asansonne.management.converter;

import it.asansonne.management.enumeration.character.RealmName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter()
public class RealmNameConverter implements AttributeConverter<RealmName, String> {

  @Override
  public String convertToDatabaseColumn(RealmName attribute) {
    return attribute == null ? null : attribute.getName();
  }

  @Override
  public RealmName convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    for (RealmName value : RealmName.values()) {
      if (dbData.equalsIgnoreCase(value.getName())) {
        return value;
      }
    }
    throw new IllegalArgumentException("Unknown RealmName: " + dbData);
  }
}
