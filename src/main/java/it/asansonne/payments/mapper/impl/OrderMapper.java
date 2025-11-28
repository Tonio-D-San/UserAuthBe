package it.asansonne.payments.mapper.impl;

import it.asansonne.authhub.mapper.RequestModelMapper;
import it.asansonne.authhub.mapper.ResponseModelMapper;
import it.asansonne.management.model.MyOrder;
import it.asansonne.payments.dto.request.paypal.MyOrderRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
@RequiredArgsConstructor
public class OrderMapper implements RequestModelMapper<MyOrderRequest, MyOrder>,
    ResponseModelMapper<MyOrder, OrdersResponse> {

  @Override
  public MyOrder toModel(MyOrderRequest dto) {
    if (dto == null) {
      return null;
    }
    return MyOrder.builder()

        .build();
  }

  @Override
  public OrdersResponse toDto(MyOrder model) {
    if (model == null) {
      return null;
    }
    return OrdersResponse.builder()
        .build();
  }

}
