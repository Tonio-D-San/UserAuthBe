package it.asansonne.management.converter;

import it.asansonne.management.enumeration.attendance.CardTransactionSource;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CardTransactionSourceConverter implements AttributeConverter<CardTransactionSource, String> {

  @Override
  public String convertToDatabaseColumn(CardTransactionSource attribute) {
    return attribute == null ? null : attribute.getDbValue();
  }

  @Override
  public CardTransactionSource convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    for (CardTransactionSource value : CardTransactionSource.values()) {
      if (dbData.equalsIgnoreCase(value.getDbValue())) {
        return value;
      }
    }
    throw new IllegalArgumentException("Unknown CardTransactionSource: " + dbData);
  }
}
