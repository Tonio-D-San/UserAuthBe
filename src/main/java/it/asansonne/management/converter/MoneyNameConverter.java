package it.asansonne.management.converter;

import it.asansonne.management.enumeration.objects.MoneyName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter()
public class MoneyNameConverter implements AttributeConverter<MoneyName, String> {

  @Override
  public String convertToDatabaseColumn(MoneyName attribute) {
    return attribute == null ? null : attribute.getName();
  }

  @Override
  public MoneyName convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    for (MoneyName value : MoneyName.values()) {
      if (dbData.equalsIgnoreCase(value.getName())) {
        return value;
      }
    }
    throw new IllegalArgumentException("Unknown MoneyName: " + dbData);
  }
}
