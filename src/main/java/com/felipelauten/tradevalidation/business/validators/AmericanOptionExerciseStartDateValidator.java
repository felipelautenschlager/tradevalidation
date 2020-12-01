package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import com.felipelauten.tradevalidation.dto.enums.Style;
import org.springframework.stereotype.Component;

@Component("AmericanOptionExerciseStartDateValidator")
public class AmericanOptionExerciseStartDateValidator implements Validator {

    private static final String VALIDATION_MESSAGE = "Excercise Start Date [%s] should be in between Trade Date and " +
            "Expiry Date";
    @Override
    public String validate(Trade trade) {
        if (trade.getStyle().equals(Style.AMERICAN)) {  // Only options with Style American are validated

            if (trade.getExcerciseStartDate().isBefore(trade.getTradeDate()) ||
                trade.getExcerciseStartDate().isAfter(trade.getExpiryDate())) {
                return String.format(VALIDATION_MESSAGE, trade.getExcerciseStartDate());
            }
        }

        return null;
    }
}
