package store.wckd.paymentservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import store.wckd.commons.paymentservice.dto.invoice.create.InvoiceCreateResponseDTO;
import store.wckd.commons.paymentservice.model.Item;
import store.wckd.commons.paymentservice.model.Payer;
import store.wckd.commons.paymentservice.model.RedirectUrls;
import store.wckd.paymentservice.converter.AutoReturnToStringConverter;
import store.wckd.paymentservice.model.invoice.body.mercadopago.MPInvoiceResponseBody;
import store.wckd.paymentservice.model.invoice.body.mercadopago.MPItemInvoiceRequestBody;
import store.wckd.paymentservice.model.invoice.body.mercadopago.MPPayerInvoiceRequestBody;
import store.wckd.paymentservice.model.invoice.body.mercadopago.MPRedirectUrlsInvoiceRequestBody;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        modelMapper.getConfiguration().setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        modelMapper.addConverter(new AutoReturnToStringConverter());

        modelMapper.createTypeMap(Item.class, MPItemInvoiceRequestBody.class)
          .addMappings(mapping -> {
              mapping.map(Item::getPictureUrl, MPItemInvoiceRequestBody::setPicture_url);
              mapping.map(Item::getCategoryId, MPItemInvoiceRequestBody::setCategory_id);
              mapping.map(Item::getUnitPrice, MPItemInvoiceRequestBody::setUnit_price);
          });

        modelMapper.createTypeMap(Payer.class, MPPayerInvoiceRequestBody.class);

        modelMapper.createTypeMap(RedirectUrls.class, MPRedirectUrlsInvoiceRequestBody.class);

        modelMapper.createTypeMap(MPInvoiceResponseBody.class, InvoiceCreateResponseDTO.class)
          .addMappings(mapping -> {
              mapping.map(MPInvoiceResponseBody::getInit_point, InvoiceCreateResponseDTO::setInvoiceUrl);
              mapping.map(MPInvoiceResponseBody::getSandbox_init_point, InvoiceCreateResponseDTO::setInvoiceSandboxUrl);
          });

        return modelMapper;
    }

}
