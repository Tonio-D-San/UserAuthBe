package it.asansonne.management.model.attendance;

import it.asansonne.authhub.model.BaseModel;
import it.asansonne.management.converter.CardTransactionSourceConverter;
import it.asansonne.management.enumeration.attendance.CardTransactionSource;
import it.asansonne.management.model.Card;
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
@Table(name = "card_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CardTransaction extends BaseModel {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "card_id", nullable = false)
  private Card card;

  @Convert(converter = CardTransactionSourceConverter.class)
  @Column(name = "source", nullable = false)
  private CardTransactionSource source;

  @Column(name = "amount", nullable = false)
  private Integer amount;

  /**
   * reference_id in DB (currently event_day_id).
   */
  @Column(name = "reference_id", nullable = false)
  private Integer referenceId;

  @Column(name = "note", columnDefinition = "TEXT")
  private String note;
}
