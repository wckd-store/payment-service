package store.wckd.paymentservice.model.invoice.body.mercadopago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MPItemInvoiceRequestBody implements Serializable {

    private String id = "";

    private String title = "";

    private String description = "";

    private String picture_url = "";

    private String category_id = "";

    private Integer quantity = 1;

    private String currency_id = "BRL";

    private Float unit_price;

}
