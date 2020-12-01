package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.springframework.stereotype.Component;

@Component("ValueDateTradeDateValidator")
public class ValueDateTradeDateValidator implements Validator {

    private static final String VALIDATION_MESSAGE = "Value Date [%s] cannot be before Trade Date [%s]";

    @Override
    public String validate(Trade trade) {
        if (trade.getValueDate().isBefore(trade.getTradeDate())) {
            return String.format(VALIDATION_MESSAGE, trade.getValueDate().toString(), trade.getTradeDate().toString());
        }

        return null;
    }

}
