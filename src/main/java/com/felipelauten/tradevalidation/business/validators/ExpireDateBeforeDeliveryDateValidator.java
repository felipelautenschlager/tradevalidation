package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.springframework.stereotype.Component;

@Component("ExpireDateBeforeDeliveryDateValidator")
public class ExpireDateBeforeDeliveryDateValidator implements Validator {

    private static final String VALIDATION_MESSAGE = "Expiry date [%s] should be before Delivery Date [%s]";

    @Override
    public String validate(Trade trade) {
        if (trade.getExpiryDate().isAfter(trade.getDeliveryDate())) {
            return String.format(VALIDATION_MESSAGE, trade.getExpiryDate(), trade.getDeliveryDate());
        }

        return null;
    }
}
