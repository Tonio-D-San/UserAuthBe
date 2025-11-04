package it.asansonne.management.service;

import it.asansonne.management.model.AbilityDefinition;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AbilityLocalizationService {
  private final MessageSource messageSource;

  public String getLocalizedDescription(AbilityDefinition def, Locale locale) {
    return messageSource.getMessage(def.getDescriptionKey(), null, locale);
  }

  public String getLocalizedName(AbilityDefinition def, Locale locale) {
    return messageSource.getMessage(def.getName(), null, locale);
  }
}

