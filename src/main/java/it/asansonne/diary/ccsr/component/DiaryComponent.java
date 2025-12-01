package it.asansonne.diary.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.diary.dto.response.DiaryResponse;
import it.asansonne.management.enumeration.character.AbilityName;

public interface DiaryComponent extends
    GetComponent<DiaryRequest, DiaryResponse>,
    PatchComponent<DiaryRequest, DiaryResponse>,
    PostComponent<DiaryRequest, DiaryResponse>
{
  DiaryResponse findByAbility(AbilityName abilityName);

}
