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

  public AbilityDefinitionDTO findAbilityDefinitionByCode(AbilityName abilityName, Locale locale) {
    AbilityDefinition def = repository.findAbilityDefinitionByCode(abilityName)
        .orElseThrow(() -> new IllegalArgumentException("Ability not found: " + abilityName));

    return AbilityDefinitionDTO.builder()
        .code(def.getCode().name())
        .name(messageSource.getMessage(def.getName(), null, locale))
        .description(messageSource.getMessage(def.getDescriptionKey(), null, locale))
        .type(def.getType().name())
        .requirementType(def.getRequirementType().name())
        .build();
  }
}
