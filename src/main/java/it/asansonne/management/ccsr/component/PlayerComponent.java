package it.asansonne.management.ccsr.component;

import it.asansonne.management.dto.response.PlayerResponse;
import java.util.Locale;
import org.springframework.data.domain.Page;

public interface PlayerComponent {
  Page<PlayerResponse> findAll(Integer page, Integer size, String direction, Locale locale);

}
