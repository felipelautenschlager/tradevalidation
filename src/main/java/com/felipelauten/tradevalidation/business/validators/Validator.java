package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;

public interface Validator {

    String validate(Trade trade);

}
