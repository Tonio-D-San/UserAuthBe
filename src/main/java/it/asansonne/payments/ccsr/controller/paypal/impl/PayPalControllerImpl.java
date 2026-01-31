package it.asansonne.payments.ccsr.controller.paypal.impl;

import static it.asansonne.authhub.constant.SharedConstant.API;
import static it.asansonne.authhub.constant.SharedConstant.API_VERSION;

import it.asansonne.payments.ccsr.component.paypal.PayPalComponent;
import it.asansonne.payments.ccsr.controller.paypal.PayPalController;
import it.asansonne.payments.dto.request.paypal.OrdersRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(API + "/" + API_VERSION + "/payments")
@AllArgsConstructor
public class PayPalControllerImpl implements PayPalController {
  private final PayPalComponent component;

  @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public OrdersResponse findByUuid(@PathVariable("uuid") UUID uuid) {
    return this.component.findByUuid(uuid);
  }

  @Override
  public Page<OrdersResponse> findByIsActive(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      @RequestParam(value = "isActive", defaultValue = "true") Boolean isActive
  ) {
    return this.component.findByIsActive(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        isActive
    );
  }

  @Override
  public Page<OrdersResponse> findAll(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
      @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
      Locale locale, Principal principal
  ) {
    return this.component.findAll(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        locale, principal
    );
  }

  @Override
  public Page<OrdersResponse> findAllByField(Integer page, Integer size, String direction,
                                             OrdersRequest request) {
    return this.component.findAllByField(
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), UPDATED_AT)),
        request
    );
  }

  @PatchMapping(
      value = "/{uuid}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @Override
  public void updateByUuid(
      @PathVariable("uuid") UUID uuid, OrdersRequest request
  ) {
    component.updateByUuid(uuid, request);
  }

  @Override
  public ResponseEntity<OrdersResponse> create(
      Principal principal,
      OrdersRequest request,
      UriComponentsBuilder builder
  ) {
    OrdersResponse response = component.create(principal, request);
    return ResponseEntity
        .created(builder
            .path(API + "/" + API_VERSION + "/payments")
            .buildAndExpand(response.getOrderId())
            .toUri()
        ).body(response);
  }
}
