package it.asansonne.diary.ccsr.service;

import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.diary.model.Diary;

public interface DiaryService extends
    GetService<Diary>, PatchService<Diary>, PostService<Diary>
{
}
