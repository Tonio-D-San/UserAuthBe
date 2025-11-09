package it.asansonne.authhub.converter;

import it.asansonne.authhub.enumeration.GroupName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class GroupNameConverter implements AttributeConverter<GroupName, String> {

  @Override
  public String convertToDatabaseColumn(GroupName groupName) {
    return groupName != null ? groupName.getName() : null;
  }

  @Override
  public GroupName convertToEntityAttribute(String dbData) {
    if (dbData == null) return null;
    return Arrays.stream(GroupName.values())
        .filter(g -> g.getName().equalsIgnoreCase(dbData))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown group name: " + dbData));
  }
}

