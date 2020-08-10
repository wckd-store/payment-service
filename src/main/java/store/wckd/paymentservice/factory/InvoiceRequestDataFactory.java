package store.wckd.paymentservice.factory;

import org.springframework.stereotype.Component;
import store.wckd.commons.dto.invoice.InvoiceCreateRequestDTO;
import store.wckd.paymentservice.exception.UnsupportedGatewayException;
import store.wckd.paymentservice.model.invoice.data.InvoiceRequestData;
import store.wckd.paymentservice.model.invoice.data.mercadopago.MercadoPagoInvoiceRequestData;

@Component
public class InvoiceRequestDataFactory {

    public InvoiceRequestData create(InvoiceCreateRequestDTO invoiceCreateRequestDTO) {
        switch (invoiceCreateRequestDTO.getPaymentGateway()) {
            case MERCADO_PAGO:
                return new MercadoPagoInvoiceRequestData(invoiceCreateRequestDTO);
            default:
                throw new UnsupportedGatewayException(invoiceCreateRequestDTO.getPaymentGateway());
        }
    }

}
