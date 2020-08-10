package store.wckd.paymentservice.model.invoice.body.mercadopago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MPInvoiceResponseBody implements Serializable {

    private String init_point;
    private String sandbox_init_point;

}
