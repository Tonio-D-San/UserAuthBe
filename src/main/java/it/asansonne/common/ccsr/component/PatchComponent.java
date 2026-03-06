package it.asansonne.common.ccsr.component;

import it.asansonne.common.dto.Request;
import java.util.UUID;

public interface PatchComponent<R extends Request> {

  void updateByUuid(UUID uuid, R request);
}
