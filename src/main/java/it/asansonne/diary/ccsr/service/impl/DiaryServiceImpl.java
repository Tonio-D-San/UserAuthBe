package it.asansonne.diary.ccsr.service.impl;

import it.asansonne.diary.ccsr.repository.DiaryRepository;
import it.asansonne.diary.ccsr.service.DiaryService;
import it.asansonne.diary.model.Diary;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiaryServiceImpl implements DiaryService {
  private final DiaryRepository playerRepository;


  @Override
  public Optional<Diary> findByUuid(UUID uuid) {
    return Optional.empty();
  }

  @Override
  public Page<Diary> findByIsActive(Pageable pageable, Boolean isActive) {
    return null;
  }

  @Override
  public Page<Diary> findAll(Pageable pageable, Locale locale) {
    return null;
  }

  @Override
  public Page<Diary> findAllByField(Pageable pageable) {
    return null;
  }

  @Override
  public Optional<Diary> findLastAdded() {
    return Optional.empty();
  }

  @Override
  public void update(Diary model) {

  }

  @Override
  public Diary create(Diary model) {
    return null;
  }
}
