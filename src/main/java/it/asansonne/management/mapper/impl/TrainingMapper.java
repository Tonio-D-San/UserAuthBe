package it.asansonne.management.mapper.impl;

import it.asansonne.common.mapper.RequestMapper;
import it.asansonne.common.mapper.ResponseMapper;
import it.asansonne.management.dto.request.TrainingRequest;
import it.asansonne.management.dto.response.TrainingResponse;
import it.asansonne.management.model.Training;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TrainingMapper implements
    RequestMapper<TrainingRequest, Training>, ResponseMapper<Training, TrainingResponse> {

  private final CharacterMapper characterMapper;

  @Override
  public Training toModel(TrainingRequest dto) {
    Training model = Training.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        .build();
    log.info("Training mapped from request: {}", model);
    return model;
  }

  @Override
  public TrainingResponse toDto(Training model) {
    TrainingResponse response = TrainingResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .name(model.getName())
        .description(model.getDescription())
        .characters(characterMapper.toDto(model.getCharacters()))
        .build();
    log.info("TrainingResponse mapped from response: {}", response);
    return response;
  }
}
