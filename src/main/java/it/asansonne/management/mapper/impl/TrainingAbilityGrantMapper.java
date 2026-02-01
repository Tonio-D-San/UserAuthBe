package it.asansonne.management.mapper.impl;

import it.asansonne.authhub.mapper.RequestMapper;
import it.asansonne.authhub.mapper.ResponseMapper;
import it.asansonne.management.dto.request.TrainingAbilityGrantRequest;
import it.asansonne.management.dto.response.TrainingAbilityGrantResponse;
import it.asansonne.management.model.TrainingAbilityGrant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TrainingAbilityGrantMapper implements
    RequestMapper<TrainingAbilityGrantRequest, TrainingAbilityGrant>, ResponseMapper<TrainingAbilityGrant, TrainingAbilityGrantResponse> {

  private final TrainingMapper trainingMapper;
  private final AbilityMapper abilityMapper;

  @Override
  public TrainingAbilityGrant toModel(TrainingAbilityGrantRequest dto) {
    TrainingAbilityGrant model = TrainingAbilityGrant.builder()
//        .training() //TODO mettere training in Component
//        .ability() //TODO mettere ability in Ccmponent
        .rankGranted(dto.getRankGranted())
        .build();
    log.info("Training mapped from request: {}", model);
    return model;
  }

  @Override
  public TrainingAbilityGrantResponse toDto(TrainingAbilityGrant model) {
    TrainingAbilityGrantResponse response = TrainingAbilityGrantResponse.builder()
        .uuid(model.getUuid())
        .updatedAt(model.getUpdatedAt())
        .training(trainingMapper.toDto(model.getTraining()))
        .ability(abilityMapper.toDto(model.getAbility()))
        .rankGranted(model.getRankGranted())
        .build();
    log.info("TrainingResponse mapped from response: {}", response);
    return response;
  }
}
