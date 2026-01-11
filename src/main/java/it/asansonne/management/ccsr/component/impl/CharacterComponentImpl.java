package it.asansonne.management.ccsr.component.impl;

import it.asansonne.authhub.ccsr.component.users.UserComponent;
import it.asansonne.authhub.model.users.User;
import it.asansonne.diary.model.Diary;
import it.asansonne.management.ccsr.component.CharacterComponent;
import it.asansonne.management.ccsr.repository.RealmRepository;
import it.asansonne.management.ccsr.service.dashboard.CharacterService;
import it.asansonne.management.dto.request.CharacterRequest;
import it.asansonne.management.dto.response.CharacterResponse;
import it.asansonne.management.enumeration.character.AbilityName;
import it.asansonne.management.mapper.impl.AbilityMapper;
import it.asansonne.management.mapper.impl.CharacterMapper;
import it.asansonne.management.model.Bag;
import it.asansonne.management.model.Card;
import it.asansonne.management.model.Character;
import java.security.Principal;
import java.util.Collections;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CharacterComponentImpl implements CharacterComponent {
  private final UserComponent userComponent;
  private final CharacterService service;
  private final CharacterMapper characterMapper;
  private final AbilityMapper abilityMapper;
  private final RealmRepository realmRepository;

  @Override
  public CharacterResponse findByAbility(AbilityName ability) {
    return characterMapper.toDto(
        service.findByAbility(ability).orElseThrow(() -> new RuntimeException("Character not found"))
    );
  }

  @Override
  public CharacterResponse findByUuid(UUID uuid) {
    return characterMapper.toDto(
        service.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Character not found"))
    );
  }

  @Override
  public Page<CharacterResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return characterMapper.toDto(service.findByIsActive(pageable, isActive), pageable);
  }

  @Override
  public Page<CharacterResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
    return characterMapper.toDto(service.findAll(pageable, locale), pageable);
  }

  @Override
  public Page<CharacterResponse> findAllByField(Pageable pageable, CharacterRequest request) {
    return characterMapper.toDto(service.findAllByField(pageable), pageable);
  }

  @Override
  public void updateByUuid(UUID uuid, CharacterRequest request) {
    service.update(characterMapper.toModel(request));
  }

  @Override
  public CharacterResponse create(Principal principal, CharacterRequest request) {
    return characterMapper.toDto(
        this.service.create(
            Character.builder()
                .pgName(request.getName())
                .background(request.getBackground())
                .diaries(Collections.singletonList(new Diary())) //TODO implement
                .training(request.getTraining())
                .realm(realmRepository
                    .findByRealmName(request.getRealm().getRealmName())
                    .orElseThrow(() -> new RuntimeException("Realm not found"))
                ).user(fromPrincipal(principal))
                .card(new Card())
                .bag(new Bag()) // TODO usare il service per creare la bag
                .abilities(abilityMapper.toModel(request.getAbilities()))
                .build()
        )
    );
    /*
    Un character alla creazione deve avere:
      - nome
      - scegliere da dove viene (regno)
      - lista di abilità (ogni abilità è da 3 punti)
      - si hanno 16 PS (punti scheda)
      - si devono usare 15 punti obbligatori
      - i PG partono con 2 PV
      - scegliere Background (storia del personaggio)
      - allegare foto costume e attrezzature
      - foto a figura intera con calzature
      - scegliere la formazione (dà abilità gratis)
      - scegliere le abilità
     */
  }

  private User fromPrincipal(Principal principal) {
    return userComponent.findUser(
        UUID.fromString(principal.getName().split("[,\\[\\]\\s]+")[1])
    );
  }

}
