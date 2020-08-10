package store.wckd.paymentservice.converter;

import org.modelmapper.AbstractConverter;
import store.wckd.commons.paymentservice.enumeration.AutoReturn;

public class AutoReturnToStringConverter extends AbstractConverter<AutoReturn, String> {
    @Override
    protected String convert(AutoReturn source) {
        return source.name().toLowerCase();
    }
}
