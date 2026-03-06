package it.asansonne.diary.mapper.impl;

import it.asansonne.common.mapper.RequestMapper;
import it.asansonne.common.mapper.ResponseMapper;
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
    Paragraph paragraph = new Paragraph();
    paragraph.setCreatedAt(dto.getDate());
    paragraph.setDescription(dto.getDescription());
    paragraph.setImages(
        dto.getImages() == null
            ? Collections.emptyList() : dto.getImages().stream()
            .map(image -> DiaryImage.builder()
                .imageData(image)
                .build())
            .toList()

    );
    return Diary.builder()
        .name(dto.getName())
        .entries(Collections.singletonList(
            DiaryEntry.builder()
                .paragraphs(
                    Collections.singletonList(paragraph)
                ).build()
        )).build();
  }


  @Override
  public DiaryResponse toDto(Diary model) {
    return model == null ? null : DiaryResponse.builder()
        .uuid(model.getUuid())
        .name(model.getName())
//        .character(characterMapper.toDto(model.getOwner()))
        .build();
  }

}
