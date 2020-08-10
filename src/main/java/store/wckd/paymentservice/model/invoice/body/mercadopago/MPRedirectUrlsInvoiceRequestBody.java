package store.wckd.paymentservice.model.invoice.body.mercadopago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MPRedirectUrlsInvoiceRequestBody implements Serializable {

    private String paymentUrl;

    private String sandboxPaymentUrl;

}
