package it.asansonne.management.model.campaign;

import it.asansonne.authhub.model.BaseModel;
import it.asansonne.management.model.attendance.CharacterAttendance;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name = "event_days")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class EventDay extends BaseModel {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "event_id", nullable = false)
  private Event event;

  @Column(name = "day_number", nullable = false)
  private Integer dayNumber;

  @Column(name = "day_date")
  private Long dayDate;

  @OneToMany(mappedBy = "eventDay")
  private List<CharacterAttendance> attendances;
}
