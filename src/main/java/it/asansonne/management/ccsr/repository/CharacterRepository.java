package it.asansonne.management.ccsr.repository;

import it.asansonne.common.ccsr.repository.GetRepository;
import it.asansonne.management.model.Character;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends
    GetRepository<Character>
{

}
