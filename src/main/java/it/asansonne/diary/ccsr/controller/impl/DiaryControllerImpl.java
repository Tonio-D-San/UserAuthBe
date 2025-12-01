package it.asansonne.diary.ccsr.controller.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.diary.ccsr.component.DiaryComponent;
import it.asansonne.diary.ccsr.controller.DiaryController;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.diary.dto.response.DiaryResponse;
import it.asansonne.diary.model.Diary;
import it.asansonne.management.enumeration.character.AbilityName;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/controller")
@AllArgsConstructor
public class DiaryControllerImpl implements DiaryController {

  private final DiaryComponent diaryComponent;

  @Override
  public Diary findDiaryByAbility(AbilityName abilityName) {
    return null;
  }

  @Override
  public DiaryResponse findByUuid(UUID uuid) {
    return null;
  }

  @Override
  public Page<DiaryResponse> findByIsActive(Integer page, Integer size, String direction,
                                            Boolean isActive) {
    return null;
  }

  @Override
  public Page<DiaryResponse> findAll(Integer page, Integer size, String direction, Locale locale,
                                     Principal principal) {
    return null;
  }

  @Override
  public Page<DiaryResponse> findAllByField(Integer page, Integer size, String direction,
                                            DiaryRequest request) {
    return null;
  }

  @Override
  public DiaryResponse findLastAdded() {
    return null;
  }

  @Override
  public void updateByUuid(UUID uuid, DiaryRequest request) {
    // TODO document why this method is empty
  }

  @Override
  public ResponseEntity<DiaryResponse> create(Principal principal, DiaryRequest request,
                                              UriComponentsBuilder builder) {
    return null;
  }
}
