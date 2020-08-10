package store.wckd.paymentservice.model.invoice.data.mercadopago;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import store.wckd.commons.dto.invoice.InvoiceCreateRequestDTO;
import store.wckd.paymentservice.model.invoice.body.mercadopago.MPInvoiceRequestBody;
import store.wckd.paymentservice.model.invoice.body.mercadopago.MPInvoiceResponseBody;
import store.wckd.paymentservice.model.invoice.data.InvoiceRequestData;
import store.wckd.paymentservice.util.Configuration;
import store.wckd.paymentservice.util.SpringContext;

import java.util.Map;

@RequiredArgsConstructor
public class MercadoPagoInvoiceRequestData implements InvoiceRequestData {

    private static final Configuration CONFIGURATION = SpringContext.getBean(Configuration.class);
    private static final ModelMapper MODEL_MAPPER = SpringContext.getBean(ModelMapper.class);

    private final InvoiceCreateRequestDTO paymentCreateRequestDTO;

    @Override
    public String getUrl() {
        return CONFIGURATION.MERCADO_PAGO_CREATE_URL;
    }

    @Override
    public MultiValueMap<String, String> getHeaders() {
        return new LinkedMultiValueMap<>();
    }

    @Override
    public Map<String, ?> getReplacements() {
        return Map.of("token", CONFIGURATION.MERCADO_PAGO_TOKEN);
    }

    @Override
    public Object getBody() {
        final MPInvoiceRequestBody map = MODEL_MAPPER.map(paymentCreateRequestDTO, MPInvoiceRequestBody.class);
        System.out.println(map);
        return map;
    }

    @Override
    public Class<?> getResponseType() {
        return MPInvoiceResponseBody.class;
    }

}
