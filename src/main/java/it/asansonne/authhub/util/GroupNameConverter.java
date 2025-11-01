package it.asansonne.authhub.util;

import it.asansonne.authhub.enumeration.GroupName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GroupNameConverter implements AttributeConverter<GroupName, String> {

  @Override
  public String convertToDatabaseColumn(GroupName attribute) {
    return attribute != null ? attribute.getName() : null;
  }

  @Override
  public GroupName convertToEntityAttribute(String dbData) {
    if (dbData == null) return null;
    for (GroupName g : GroupName.values()) {
      if (g.getName().equalsIgnoreCase(dbData)) return g;
    }
    throw new IllegalArgumentException("Unknown database value: " + dbData);
  }
}
