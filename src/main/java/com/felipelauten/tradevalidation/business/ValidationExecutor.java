package com.felipelauten.tradevalidation.business;

import com.felipelauten.tradevalidation.business.validators.RequiredFieldsValidator;
import com.felipelauten.tradevalidation.business.validators.Validator;
import com.felipelauten.tradevalidation.dto.Trade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationExecutor {

    public static final String MISSING_THE_REQUIRED_FIELDS = "Trade is missing the required fields.";

    private List<Validator> validators;
    private RequiredFieldsValidator requiredFieldsValidator;

    public ValidationExecutor(List<Validator> validators, RequiredFieldsValidator requiredFieldsValidator) {
        if (validators == null) {
            this.validators = Collections.emptyList();
        } else {
            this.validators = validators;
        }
        this.requiredFieldsValidator = requiredFieldsValidator;
    }

    /**
     * Executes the validation of the <code>Trade</code> object
     * against the list of validators and the required fields validator
     * @param trade to execute validation
     * @return <code>List</code> of validation Strings
     */
    public List<String> execute(Trade trade) {
        List<String> validationErrors = new ArrayList<>();

        if (this.requiredFieldsValidator.isValid(trade)) {
            for (Validator validator : validators) {
                String validationResult = validator.validate(trade);
                if (validationResult != null) {
                    validationErrors.add(validationResult);
                }
            }
        } else {
            validationErrors.add(MISSING_THE_REQUIRED_FIELDS);
        }

        return validationErrors;
    }

    public List<Validator> getValidators() {
        return validators;
    }
}
