package it.asansonne.management.ccsr.component;

import it.asansonne.management.dto.response.AbilityResponse;
import java.util.Locale;
import org.springframework.data.domain.Page;

public interface AbilityComponent {
  Page<AbilityResponse> findAll(Integer page, Integer size, String direction, Locale locale);
}
