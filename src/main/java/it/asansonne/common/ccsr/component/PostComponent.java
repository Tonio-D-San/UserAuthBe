package it.asansonne.common.ccsr.component;

import it.asansonne.common.dto.Request;
import it.asansonne.common.dto.Response;
import java.security.Principal;

public interface PostComponent<R extends Request, S extends Response> {

  S create(Principal principal, R request);
}
