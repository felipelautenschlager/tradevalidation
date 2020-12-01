package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import com.felipelauten.tradevalidation.dto.enums.Style;
import org.springframework.stereotype.Component;

@Component("OptionRequiredFieldsValidator")
public class OptionRequiredFieldsValidator extends TradeRequiredFieldsValidator implements RequiredFieldsValidator {

    @Override
    public boolean isValid(Trade trade) {
        boolean result = true;

        // Only applicable to AMERICAN Style of Options
        if (Style.AMERICAN.equals(trade.getStyle()) && trade.getExcerciseStartDate() == null) {
            result = false;
        }
        if (trade.getExpiryDate() == null) {
            result = false;
        }
        if (trade.getPremiumDate() == null) {
            result = false;
        }

        return super.isValid(trade) && result;
    }
}
