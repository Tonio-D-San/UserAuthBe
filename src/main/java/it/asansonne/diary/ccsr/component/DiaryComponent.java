package it.asansonne.diary.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;

import it.asansonne.diary.dto.request.DiaryRequest;
import it.asansonne.diary.dto.response.DiaryResponse;
import java.util.Locale;
import org.springframework.data.domain.Page;

public interface DiaryComponent extends
    GetComponent<DiaryRequest, DiaryResponse>,
    PatchComponent<DiaryRequest, DiaryResponse>,
    PostComponent<DiaryRequest, DiaryResponse>
{
  Page<DiaryResponse> findAll(Integer page, Integer size, String direction, Locale locale);

}
