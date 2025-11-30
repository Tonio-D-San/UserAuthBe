package it.asansonne.authhub.ccsr.component;

import it.asansonne.authhub.dto.Request;
import it.asansonne.authhub.dto.Response;
import java.security.Principal;

public interface PostComponent<R extends Request, S extends Response> {

  S create(Principal principal, R request);
}
