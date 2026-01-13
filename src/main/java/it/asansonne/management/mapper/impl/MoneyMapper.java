package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.management.dto.request.MoneyRequest;
import it.asansonne.management.model.Money;
import org.springframework.stereotype.Component;

@Component
public class MoneyMapper implements RequestMapper<MoneyRequest, Money> {

  @Override
  public Money toModel(MoneyRequest dto) {
    return dto == null ? null : Money.builder()
        .moneyName(dto.getMoneyName())
        .build();
  }
}
