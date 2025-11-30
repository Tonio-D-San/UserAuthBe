package it.asansonne.management.ccsr.component;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.management.dto.request.PlayerRequest;
import it.asansonne.management.dto.response.PlayerResponse;
import java.util.Locale;
import org.springframework.data.domain.Page;

public interface PlayerComponent extends
    GetComponent<PlayerRequest, PlayerResponse>,
    PatchComponent<PlayerRequest, PlayerResponse>,
    PostComponent<PlayerRequest, PlayerResponse>
{
  Page<PlayerResponse> findAll(Integer page, Integer size, String direction, Locale locale);

}
