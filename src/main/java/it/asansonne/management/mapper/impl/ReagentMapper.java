package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.ReagentRequest;
import it.asansonne.management.dto.response.BagResponse;
import it.asansonne.management.dto.response.ReagentResponse;
import it.asansonne.management.model.Bag;
import it.asansonne.management.model.Reagent;
import org.springframework.stereotype.Component;

@Component
public class ReagentMapper implements
    RequestMapper<ReagentRequest, Reagent>, ResponseMapper<Reagent, ReagentResponse> {

  @Override
  public Reagent toModel(ReagentRequest dto) {
    return dto == null ? null : Reagent.builder()
        .reagentName(dto.getReagentName())
        .build();
  }

  @Override
  public ReagentResponse toDto(Reagent model) {
    return ReagentResponse.builder()
        .build();
  }
}
