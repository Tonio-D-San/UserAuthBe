package it.asansonne.diary.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.diary.model.Diary;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends
    GetRepository<Diary>
{

}
