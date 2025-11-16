package it.asansonne.management.ccsr.component.impl;

import it.asansonne.management.ccsr.component.PlayerComponent;
import it.asansonne.management.dto.response.PlayerResponse;
import java.util.Locale;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerComponentImpl implements PlayerComponent {
//  private final PlayerService service;

  public Page<PlayerResponse> findAll(Integer page, Integer size, String direction, Locale locale) {
//    return service.findAll();
    return null;
  }

}
