package store.wckd.paymentservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

    @Value("${gateway.mercado-pago.url.create}")
    public String MERCADO_PAGO_CREATE_URL;

    @Value("${gateway.mercado-pago.token}")
    public String MERCADO_PAGO_TOKEN;

}
