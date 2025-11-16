package it.asansonne.management.ccsr.controller;

import io.swagger.v3.oas.annotations.Parameter;
import it.asansonne.authhub.dto.Request;
import it.asansonne.authhub.dto.Response;
import jakarta.validation.Valid;
import java.util.Locale;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

public interface GetController<R extends Request, S extends Response> {
  String ORDER = "creationDate";

  S findByUuid(
      @Parameter(name = "uuid", description = "uuid",
          example = "081081d1-1777-4b59-8b4b-e9ab26186006") UUID uuid);

  Page<S> findActive(
      @Parameter(name = "page", description = "page number") Integer page,
      @Parameter(name = "size", description = "element's number in page") Integer size,
      @Parameter(name = "direction", description = "order direction") String direction,
      @Parameter(name = "isActive", description = "find active") Boolean isActive
  );

  Page<S> findAll(
      @Parameter(name = "page", description = "page number") Integer page,
      @Parameter(name = "size", description = "element's number in page") Integer size,
      @Parameter(name = "direction", description = "order direction") String direction,
      Locale locale
  );

  Page<S> findAllByField(
      @Parameter(name = "page", description = "page number") Integer page,
      @Parameter(name = "size", description = "element's number in page") Integer size,
      @Parameter(name = "direction", description = "order direction") String direction,
      @Valid @RequestBody R request);

  S findLastAdded();
}
