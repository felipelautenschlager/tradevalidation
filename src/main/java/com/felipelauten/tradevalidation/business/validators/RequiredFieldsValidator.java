package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;

public interface RequiredFieldsValidator {

    boolean isValid(Trade trade);

}
