package store.wckd.paymentservice.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import store.wckd.paymentservice.model.invoice.data.InvoiceRequestData;

@Service
public class RequestService {

    private final RestTemplate restTemplate;

    public RequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object requestInvoiceCreation(InvoiceRequestData invoiceRequestData) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.addAll(invoiceRequestData.getHeaders());

        HttpEntity<Object> httpEntity = new HttpEntity<>(invoiceRequestData.getBody(), httpHeaders);

        return restTemplate.postForObject(
          invoiceRequestData.getUrl(),
          httpEntity,
          invoiceRequestData.getResponseType(),
          invoiceRequestData.getReplacements()
        );
    }

}
