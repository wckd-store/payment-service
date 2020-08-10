package store.wckd.paymentservice.model.invoice.body.mercadopago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MPInvoiceRequestBody implements Serializable {

    private MPItemInvoiceRequestBody[] items;

    private MPPayerInvoiceRequestBody payer;

    private MPRedirectUrlsInvoiceRequestBody back_urls;

    private String auto_return;

    private String notification_url;

}
