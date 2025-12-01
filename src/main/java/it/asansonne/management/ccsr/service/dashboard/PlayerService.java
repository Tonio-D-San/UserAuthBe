package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.model.Player;

public interface PlayerService extends
    GetService<Player>, PatchService<Player>, PostService<Player>
{
}
