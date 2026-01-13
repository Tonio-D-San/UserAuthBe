package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.management.dto.request.CardRequest;
import it.asansonne.management.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper implements RequestMapper<CardRequest, Card> {

  @Override
  public Card toModel(CardRequest dto) {
    return dto == null ? null : Card.builder()
        .totalPoints(dto.getTotalPoints())
        // availablePoints/usedPoints are computed in CardService
        .build();
  }
}
