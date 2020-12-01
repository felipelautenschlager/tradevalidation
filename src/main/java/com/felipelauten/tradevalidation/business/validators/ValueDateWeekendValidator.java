package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component("ValueDateWeekendValidator")
public class ValueDateWeekendValidator implements Validator {

    private static String VALIDATION_MESSAGE = "Value Date [%s] cannot fall on weekend";

    @Override
    public String validate(Trade trade) {
        if(trade.getValueDate().getDayOfWeek() == DayOfWeek.SATURDAY ||
            trade.getValueDate().getDayOfWeek() == DayOfWeek.SUNDAY) {
            return String.format(VALIDATION_MESSAGE, trade.getValueDate());
        }

        return null;
    }
}
