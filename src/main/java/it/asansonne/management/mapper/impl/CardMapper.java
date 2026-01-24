package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.CardRequest;
import it.asansonne.management.dto.response.CardResponse;
import it.asansonne.management.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper implements
    RequestMapper<CardRequest, Card>, ResponseMapper<Card, CardResponse> {

  private final CharacterMapper characterMapper;

  public CardMapper(CharacterMapper characterMapper) {
    this.characterMapper = characterMapper;
  }

  @Override
  public Card toModel(CardRequest dto) {
    return dto == null ? null : Card.builder()
        .totalPoints(dto.getTotalPoints())
        // availablePoints/usedPoints are computed in CardService
        .build();
  }

  @Override
  public CardResponse toDto(Card model) {
    return model == null ? null : CardResponse.builder()
        .uuid(model.getUuid())
//        .description("Scheda di {}", model.getCharacter().getPgName()) //TODO da capire
        .character(characterMapper.toDto(model.getCharacter()))
        .build();
  }
}
