package it.asansonne.authhub.ccsr.component;

import it.asansonne.authhub.dto.Request;
import it.asansonne.authhub.dto.Response;
import java.util.UUID;

public interface PatchComponent<R extends Request, S extends Response> {

  void updateByUuid(UUID uuid, R request);
}
