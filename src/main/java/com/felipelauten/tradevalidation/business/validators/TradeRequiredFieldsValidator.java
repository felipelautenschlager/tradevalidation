package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.springframework.stereotype.Component;

@Component("TradeRequiredFieldsValidator")
public class TradeRequiredFieldsValidator implements RequiredFieldsValidator {

    @Override
    public boolean isValid(Trade trade) {
        boolean result = true;

        if (trade.getValueDate() == null) {
            result = false;
        }
        if (trade.getTradeDate() == null) {
            result = false;
        }
        if (trade.getCustomer() == null || "".equals(trade.getCustomer())) {
            result = false;
        }
        if (trade.getCcyPair() == null || "".equals(trade.getCcyPair())) {
            result = false;
        }

        return result;
    }
}
