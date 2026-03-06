package it.asansonne.payments.ccsr.component.paypal;

import it.asansonne.common.ccsr.component.GetComponent;
import it.asansonne.common.ccsr.component.PatchComponent;
import it.asansonne.common.ccsr.component.PostComponent;
import it.asansonne.payments.dto.request.paypal.OrdersRequest;
import it.asansonne.payments.dto.response.paypal.OrdersResponse;

public interface PayPalComponent extends
    GetComponent<OrdersResponse>,
    PatchComponent<OrdersRequest>,
    PostComponent<OrdersRequest, OrdersResponse>
{

}
