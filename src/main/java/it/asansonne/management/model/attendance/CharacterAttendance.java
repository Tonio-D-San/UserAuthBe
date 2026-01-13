package it.asansonne.management.model.attendance;

import it.asansonne.authhub.model.BaseModel;
import it.asansonne.management.converter.AttendanceStatusConverter;
import it.asansonne.management.enumeration.attendance.AttendanceStatus;
import it.asansonne.management.model.Character;
import it.asansonne.management.model.campaign.EventDay;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name = "character_attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CharacterAttendance extends BaseModel {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "character_id", nullable = false)
  private Character character;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "event_day_id", nullable = false)
  private EventDay eventDay;

  @Convert(converter = AttendanceStatusConverter.class)
  @Column(name = "status", nullable = false)
  private AttendanceStatus status = AttendanceStatus.PRESENT;
}
