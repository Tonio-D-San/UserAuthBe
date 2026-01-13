package it.asansonne.management.converter;

import it.asansonne.management.enumeration.attendance.AttendanceStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class AttendanceStatusConverter implements AttributeConverter<AttendanceStatus, String> {

  @Override
  public String convertToDatabaseColumn(AttendanceStatus attribute) {
    return attribute == null ? null : attribute.getDbValue();
  }

  @Override
  public AttendanceStatus convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    for (AttendanceStatus value : AttendanceStatus.values()) {
      if (dbData.equalsIgnoreCase(value.getDbValue())) {
        return value;
      }
    }
    throw new IllegalArgumentException("Unknown AttendanceStatus: " + dbData);
  }
}
