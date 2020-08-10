package store.wckd.paymentservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.wckd.commons.paymentservice.dto.invoice.create.InvoiceCreateRequestDTO;
import store.wckd.commons.paymentservice.dto.invoice.create.InvoiceCreateResponseDTO;
import store.wckd.paymentservice.service.InvoiceService;

import javax.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public InvoiceCreateResponseDTO create(@Valid @RequestBody InvoiceCreateRequestDTO invoiceCreateRequestDTO) {
        System.out.println(invoiceCreateRequestDTO);
        return invoiceService.createPayment(invoiceCreateRequestDTO);
    }

}
