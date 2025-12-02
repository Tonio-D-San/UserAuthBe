package it.asansonne.management.ccsr.service;

import it.asansonne.management.ccsr.repository.AbilityDefinitionRepository;
import it.asansonne.management.dto.AbilityDefinitionDTO;
import it.asansonne.management.dto.response.AbilityResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.enumeration.ReagentName;
import it.asansonne.management.model.Ability;
import it.asansonne.management.model.Reagent;
import it.asansonne.authhub.ccsr.service.users.impl.LocalizationServiceImpl;
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
  private final AbilityDefinitionRepository abilityRepository;
  private final LocalizationServiceImpl localizationService;

  public Page<AbilityResponse> findAll(int page, int size, String direction, Locale locale) {
    Page<Ability> defs = abilityRepository.findAll(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "code"))
    );

    return defs.map(def -> new AbilityResponse(
        def.getCode(),
        localizationService.getLocalizedName(def, locale),
        localizationService.getLocalizedDescription(def, locale),
        def.getType(),
        def.getRequirementType()
    ));
  }

  public AbilityDefinitionDTO findAbilityDefinitionByCode(AbilityName abilityName, Locale locale) {
    Ability def = abilityRepository.findAbilityDefinitionByCode(abilityName)
        .orElseThrow(() -> new IllegalArgumentException("Ability not found: " + abilityName));

    String c1 = Reagent.builder()
        .reagentName(ReagentName.REAGENT_A)
        .build().getReagentName().getName();
    String c2 = Reagent.builder()
        .reagentName(ReagentName.REAGENT_B)
        .build().getReagentName().getName();
    
    return AbilityDefinitionDTO.builder()
        .code(def.getCode().name())
        .name(messageSource.getMessage(def.getName(), null, locale))
        .description(
            messageSource.getMessage(def.getDescriptionKey(),
            new Object[]{c1, c2},
            locale)
        ).type(def.getType().name())
        .requirementType(def.getRequirementType().name())
        .build();
  }
  
    /* TODO per gestire l'i18n in modo dinamico
  herbal_transmutation.description=... consumando materiali aggiuntivi: {0}.
  String consumables = consumableService.listBySkill("HERBAL_TRANSMUTATION")
    .stream()
    .map(Consumable::getName)
    .collect(Collectors.joining(", "));

  String finalDesc = messageSource.getMessage("herbal_transmutation.description",
                                              new Object[]{consumables},
                                              locale);
   */
}
