package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.management.dto.request.BagRequest;
import it.asansonne.management.model.Bag;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class BagMapper implements RequestMapper<BagRequest, Bag> {

  @Override
  public Bag toModel(BagRequest dto) {
    return dto == null ? null : Bag.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        // money/reagents are mapped and linked in BagService
        .money(new ArrayList<>())
        .reagents(new ArrayList<>())
        .build();
  }
}
