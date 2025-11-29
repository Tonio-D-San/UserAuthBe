package it.asansonne.management.ccsr.controller;

import it.asansonne.authhub.dto.Request;
import it.asansonne.authhub.dto.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

public interface PostController<R extends Request, S extends Response> {
  ResponseEntity<S> create(@Valid @RequestBody R request, UriComponentsBuilder builder);
}
