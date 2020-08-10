package store.wckd.paymentservice.exception;

import lombok.Getter;
import store.wckd.commons.enumeration.PaymentGateway;

@Getter
public class UnsupportedGatewayException extends RuntimeException {

    private final PaymentGateway paymentGateway;
    private final String message;

    public UnsupportedGatewayException(PaymentGateway paymentGateway) {
        this(paymentGateway, paymentGateway.name() + " gateway isn't supported yet.");
    }

    public UnsupportedGatewayException(PaymentGateway paymentGateway, String message) {
        this.paymentGateway = paymentGateway;
        this.message = message;
    }

}
