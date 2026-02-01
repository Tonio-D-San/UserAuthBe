package it.asansonne.payments.ccsr.controller.paypal;

import static it.asansonne.authhub.constant.SharedConstant.AUTH_HUB_API_VERSION;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.asansonne.authhub.ccsr.controller.GetController;
import it.asansonne.authhub.ccsr.controller.PatchController;
import it.asansonne.authhub.ccsr.controller.PostController;
import it.asansonne.payments.dto.request.paypal.OrdersRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;

@Tag(name = "PayPalController" + AUTH_HUB_API_VERSION)
public interface PayPalController extends
    GetController<OrdersRequest, OrdersResponse>,
    PatchController<OrdersRequest, OrdersResponse>,
    PostController<OrdersRequest, OrdersResponse>
{

}
