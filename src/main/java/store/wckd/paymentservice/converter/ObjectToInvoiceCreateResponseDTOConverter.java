package store.wckd.paymentservice.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import store.wckd.commons.paymentservice.dto.invoice.create.InvoiceCreateResponseDTO;
import store.wckd.paymentservice.model.invoice.body.mercadopago.MPInvoiceResponseBody;

@RequiredArgsConstructor
public class ObjectToInvoiceCreateResponseDTOConverter extends AbstractConverter<Object, InvoiceCreateResponseDTO> {

    private final ModelMapper modelMapper;

    @Override
    protected InvoiceCreateResponseDTO convert(Object source) {
        if (source instanceof MPInvoiceResponseBody)
            modelMapper.map(source, InvoiceCreateResponseDTO.class);

        throw new NullPointerException();
    }

}
