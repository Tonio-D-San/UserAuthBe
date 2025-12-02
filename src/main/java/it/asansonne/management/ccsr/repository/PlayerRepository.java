package it.asansonne.management.ccsr.repository;

import it.asansonne.authhub.ccsr.repository.GetRepository;
import it.asansonne.management.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends
    GetRepository<Player>
{

}
