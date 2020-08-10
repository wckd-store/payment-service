package store.wckd.paymentservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import store.wckd.commons.paymentservice.dto.invoice.create.InvoiceCreateRequestDTO;
import store.wckd.commons.paymentservice.dto.invoice.create.InvoiceCreateResponseDTO;
import store.wckd.paymentservice.factory.InvoiceRequestDataFactory;
import store.wckd.paymentservice.model.invoice.data.InvoiceRequestData;

@Service
public class InvoiceService {

    private final InvoiceRequestDataFactory invoiceRequestDataFactory;
    private final RequestService requestService;
    private final ModelMapper modelMapper;

    public InvoiceService(InvoiceRequestDataFactory invoiceRequestDataFactory, RequestService requestService, ModelMapper modelMapper) {
        this.invoiceRequestDataFactory = invoiceRequestDataFactory;
        this.requestService = requestService;
        this.modelMapper = modelMapper;
    }

    public InvoiceCreateResponseDTO createPayment(InvoiceCreateRequestDTO invoiceCreateRequestDTO) {
        InvoiceRequestData invoiceRequestData = invoiceRequestDataFactory.create(invoiceCreateRequestDTO);
        return modelMapper.map(requestService.requestInvoiceCreation(invoiceRequestData), InvoiceCreateResponseDTO.class);

    }

}
