package it.asansonne.diary.ccsr.component.impl;

import it.asansonne.diary.ccsr.component.DiaryComponent;
import it.asansonne.diary.ccsr.service.DiaryService;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.diary.dto.response.DiaryResponse;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DiaryComponentImpl implements DiaryComponent {

  private final DiaryService diaryService;

  @Override
  public Page<DiaryResponse> findAll(Integer page, Integer size, String direction, Locale locale) {
    return null;
  }

  @Override
  public DiaryResponse findByUuid(UUID uuid) {
    return null;
  }

  @Override
  public Page<DiaryResponse> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<DiaryResponse> findAll(Pageable pageable, Locale locale, Principal principal) {
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

  }

  @Override
  public DiaryResponse create(Principal principal, DiaryRequest request) {
    return null;
  }
}
