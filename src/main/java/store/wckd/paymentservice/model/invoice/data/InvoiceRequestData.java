package store.wckd.paymentservice.model.invoice.data;

import org.springframework.util.MultiValueMap;

import java.util.Map;

public interface InvoiceRequestData {

    String getUrl();

    MultiValueMap<String, String> getHeaders();

    Map<String, ?> getReplacements();

    Object getBody();

    Class<?> getResponseType();

}
