package it.asansonne.diary.mapper.impl;//package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.diary.dto.response.DiaryResponse;
import it.asansonne.diary.model.Diary;
import it.asansonne.diary.model.DiaryEntry;
import it.asansonne.diary.model.DiaryImage;
import it.asansonne.diary.model.Paragraph;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class DiaryMapper implements
    RequestMapper<DiaryRequest, Diary>, ResponseMapper<Diary, DiaryResponse> {

  @Override
  public Diary toModel(DiaryRequest dto) {
    if (dto == null) {
      return null;
    }

    return Diary.builder()
        .name(dto.getName())
        .entries(Collections.singletonList(
            DiaryEntry.builder()
                .paragraphs(Collections.singletonList(
                    Paragraph.builder()
                        .date(dto.getDate())
                        .description(dto.getDescription())
                        .images(dto.getImages() == null
                            ? Collections.emptyList() : dto.getImages().stream()
                                .map(image -> DiaryImage.builder()
                                    .imageData(image)
                                    .build())
                                .toList()
                        ).build()
                )).build()
        )).build();
  }


  @Override
  public DiaryResponse toDto(Diary model) {
    return model == null ? null : DiaryResponse.builder()
        .uuid(model.getUuid())
        .name(model.getName())
//        .player(playerMapper.toDto(model.getOwner()))
        .build();
  }

}
