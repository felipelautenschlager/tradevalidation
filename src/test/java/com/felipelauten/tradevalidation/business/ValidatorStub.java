package com.felipelauten.tradevalidation.business;

import com.felipelauten.tradevalidation.business.validators.Validator;
import com.felipelauten.tradevalidation.dto.Trade;

public class ValidatorStub implements Validator {

    private String id;

    public ValidatorStub(String id) {
        this.id = id;
    }

    @Override
    public String validate(Trade trade) {
        return String.format("Validated %s", id);
    }

}