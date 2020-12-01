package com.felipelauten.tradevalidation.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationEntry {

    private static final String NO_ERRORS_FOUND = "No errors found.";
    private static final String ERRORS_FOUND = "%s errors found.";

    private Trade trade;
    private List<String> validationErrors;

    public ValidationEntry(Trade trade) {
        this.trade = trade;
        this.validationErrors = new ArrayList<>();
    }

    public void addValidationErrors(List<String> errors) {
        if (errors != null) {
            this.validationErrors.addAll(errors);
        }
    }

    public boolean hasErrors() {
        return this.validationErrors.size() > 0;
    }

    public String getResult() {
        if (this.validationErrors.isEmpty()) {
            return NO_ERRORS_FOUND;
        } else {
            return String.format(ERRORS_FOUND, this.validationErrors.size());
        }
    }

    public Trade getTrade() {
        return trade;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }
}
