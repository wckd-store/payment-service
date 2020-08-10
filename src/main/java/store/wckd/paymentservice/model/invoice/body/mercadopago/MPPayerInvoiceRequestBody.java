package store.wckd.paymentservice.model.invoice.body.mercadopago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MPPayerInvoiceRequestBody implements Serializable {

    private String name = "";

    private String surname = "";

    private String email = "";

}
