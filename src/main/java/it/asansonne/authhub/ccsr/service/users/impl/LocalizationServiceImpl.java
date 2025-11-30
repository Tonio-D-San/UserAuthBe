package it.asansonne.authhub.ccsr.service.users.impl;

import it.asansonne.authhub.ccsr.service.users.LocalizationService;
import it.asansonne.management.model.AbilityDefinition;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocalizationServiceImpl implements LocalizationService<AbilityDefinition> {
  private final MessageSource messageSource;

  public String getLocalizedName(AbilityDefinition def, Locale locale) {
    return messageSource.getMessage(def.getName(), null, locale);
  }

  public String getLocalizedDescription(AbilityDefinition def, Locale locale) {
    return messageSource.getMessage(def.getDescriptionKey(), null, locale);
  }
}

