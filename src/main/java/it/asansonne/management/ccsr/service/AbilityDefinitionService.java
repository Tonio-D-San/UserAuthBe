package it.asansonne.management.ccsr.service;

import it.asansonne.management.ccsr.repository.AbilityDefinitionRepository;
import it.asansonne.management.dto.AbilityDefinitionDTO;
import it.asansonne.management.enumeration.AbilityName;
import it.asansonne.management.model.AbilityDefinition;
import it.asansonne.management.service.AbilityLocalizationService;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AbilityDefinitionService {
  private final MessageSource messageSource;
  private final AbilityDefinitionRepository repository;
  private final AbilityLocalizationService localizationService;

  public Page<AbilityDefinitionDTO> findAll(int page, int size, String direction, Locale locale) {
    Page<AbilityDefinition> defs = repository.findAll(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "code"))
    );

    return defs.map(def -> new AbilityDefinitionDTO(
        def.getCode().name(),
        localizationService.getLocalizedName(def, locale),
        localizationService.getLocalizedDescription(def, locale),
        def.getType().name(),
        def.getRequirementType().name()
    ));
  }

  public AbilityDefinition findAbilityDefinitionByCode(AbilityName abilityName) {
    return repository.findAbilityDefinitionByCode(abilityName).orElse(
        AbilityDefinition.builder()
            .code(AbilityName.CARTOGRAPHER)
            .name(messageSource.getMessage("cartographer.name", null, Locale.ITALIAN))
            .descriptionKey("cartographer.description")
            .build()
    );
  }
}
