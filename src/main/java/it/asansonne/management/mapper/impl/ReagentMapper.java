package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.management.dto.request.ReagentRequest;
import it.asansonne.management.model.Reagent;
import org.springframework.stereotype.Component;

@Component
public class ReagentMapper implements RequestMapper<ReagentRequest, Reagent> {

  @Override
  public Reagent toModel(ReagentRequest dto) {
    return dto == null ? null : Reagent.builder()
        .reagentName(dto.getReagentName())
        .build();
  }
}
