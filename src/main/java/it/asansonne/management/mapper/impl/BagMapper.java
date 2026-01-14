package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.BagRequest;
import it.asansonne.management.dto.response.BagResponse;
import it.asansonne.management.model.Bag;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BagMapper implements
    RequestMapper<BagRequest, Bag>, ResponseMapper<Bag, BagResponse> {

  private final CharacterMapper characterMapper;
  private final MoneyMapper moneyMapper;
  private final ReagentMapper reagentMapper;

  @Override
  public Bag toModel(BagRequest dto) {
    return dto == null ? null : Bag.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        .money(moneyMapper.toModel(dto.getMoney()))
        .reagents(reagentMapper.toModel(dto.getReagents()))
        .build();
  }

  @Override
  public BagResponse toDto(Bag model) {
    return model == null ? null : BagResponse.builder()
        .uuid(model.getUuid())
        .name(model.getName())
        .description(model.getDescription())
        .money(moneyMapper.toDto(model.getMoney()))
        .reagents(reagentMapper.toDto(model.getReagents()))
        .character(characterMapper.toDto(model.getOwner()))
        .build();
  }
}
