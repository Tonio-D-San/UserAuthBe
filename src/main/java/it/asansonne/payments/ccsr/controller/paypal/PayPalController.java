package it.asansonne.payments.ccsr.controller.paypal;

import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.payments.dto.request.paypal.OrdersRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;

public interface PayPalController extends
    PostController<OrdersRequest, OrdersResponse>
{

}
