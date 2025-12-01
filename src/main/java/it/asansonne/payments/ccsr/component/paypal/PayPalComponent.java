package it.asansonne.payments.ccsr.component.paypal;

import it.asansonne.authhub.ccsr.component.GetComponent;
import it.asansonne.authhub.ccsr.component.PatchComponent;
import it.asansonne.authhub.ccsr.component.PostComponent;
import it.asansonne.payments.dto.request.paypal.OrdersRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;

public interface PayPalComponent extends
    GetComponent<OrdersRequest, OrdersResponse>,
    PatchComponent<OrdersRequest, OrdersResponse>,
    PostComponent<OrdersRequest, OrdersResponse>
{

}
