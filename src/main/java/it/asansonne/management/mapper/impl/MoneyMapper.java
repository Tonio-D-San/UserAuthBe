package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.MoneyRequest;
import it.asansonne.management.dto.response.BagResponse;
import it.asansonne.management.dto.response.MoneyResponse;
import it.asansonne.management.model.Bag;
import it.asansonne.management.model.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoneyMapper implements
    RequestMapper<MoneyRequest, Money>, ResponseMapper<Money, MoneyResponse> {

  @Override
  public Money toModel(MoneyRequest dto) {
    return dto == null ? null : Money.builder()
        .moneyName(dto.getMoneyName())
        .build();
  }

  @Override
  public MoneyResponse toDto(Money model) {
    return MoneyResponse.builder().build();
  }
}
