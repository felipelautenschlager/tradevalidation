package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.springframework.stereotype.Component;

@Component("PremiumDateBeforeDeliveryDateValidator")
public class PremiumDateBeforeDeliveryDateValidator implements Validator {

    private static final String VALIDATION_MESSAGE = "Premium Date [%s] should be before Delivery Date [%s]";

    @Override
    public String validate(Trade trade) {
        if (trade.getPremiumDate().isAfter(trade.getDeliveryDate())) {
            return String.format(VALIDATION_MESSAGE, trade.getPremiumDate(), trade.getDeliveryDate());
        }

        return null;
    }
}
