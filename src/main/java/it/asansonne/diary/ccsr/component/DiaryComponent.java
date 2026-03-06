package it.asansonne.diary.ccsr.component;

import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.diary.dto.response.DiaryResponse;
import it.asansonne.management.enumeration.character.AbilityName;

public interface DiaryComponent extends
    GetComponent<DiaryResponse>,
    PatchComponent<DiaryRequest>,
    PostComponent<DiaryRequest, DiaryResponse>
{
  DiaryResponse findByAbility(AbilityName abilityName);

}
