package it.asansonne.diary.ccsr.controller;

import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.diary.dto.response.DiaryResponse;
import it.asansonne.diary.model.Diary;
import it.asansonne.management.enumeration.character.AbilityName;

public interface DiaryController extends
    GetController<DiaryRequest, DiaryResponse> ,
    PostController<DiaryRequest, DiaryResponse>,
    PatchController<DiaryRequest, DiaryResponse>
{
  Diary findDiaryByAbility(AbilityName abilityName);

}
