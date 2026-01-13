package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import it.asansonne.management.converter.MoneyNameConverter;
import it.asansonne.management.enumeration.objects.MoneyName;
import jakarta.persistence.Convert;
import jakarta.persistence.Column;
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
@Table(name = "money")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Money extends BaseModel {
  @Column(name = "money_name", length = 50)
  @Convert(converter = MoneyNameConverter.class)
  private MoneyName moneyName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bag_id", nullable = false)
  private Bag bag;
}
