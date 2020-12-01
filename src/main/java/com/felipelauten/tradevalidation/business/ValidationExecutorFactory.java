package com.felipelauten.tradevalidation.business;

import com.felipelauten.tradevalidation.business.validators.RequiredFieldsValidator;
import com.felipelauten.tradevalidation.business.validators.Validator;
import com.felipelauten.tradevalidation.dto.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component("ValidationExecutorFactory")
public class ValidationExecutorFactory {

    @Autowired
    @Qualifier("TradeRequiredFieldsValidator")
    private RequiredFieldsValidator tradeRequiredFieldsValidator;

    @Autowired
    @Qualifier("OptionRequiredFieldsValidator")
    private RequiredFieldsValidator optionRequiredFieldsValidator;

    @Autowired
    @Qualifier("AmericanOptionExerciseStartDateValidator")
    private Validator americanOptionExerciseStartDateValidator;

    @Autowired
    @Qualifier("CounterpartyValidator")
    private Validator counterpartyValidator;

    @Autowired
    @Qualifier("CurrencyPairValidator")
    private Validator currencyPairValidator;

    @Autowired
    @Qualifier("ExpireDateBeforeDeliveryDateValidator")
    private Validator expireDateBeforeDeliveryDateValidator;

    @Autowired
    @Qualifier("PremiumDateBeforeDeliveryDateValidator")
    private Validator premiumDateBeforeDeliveryDateValidator;

    @Autowired
    @Qualifier("ValueDateTradeDateValidator")
    private Validator valueDateTradeDateValidator;

    @Autowired
    @Qualifier("ValueDateWeekendValidator")
    private Validator valueDateWeekendValidator;

    /**
     * Gets the appropriate <code>ValidationExecutor</code> for the type
     * of Trade.
     * @param trade trade build the appropriate Executor
     * @return ValidationExecutor with all the validators set.
     */
    public ValidationExecutor getValidationExecutor(Trade trade) {
        ValidationExecutor executor;
        switch (trade.getType()) {
            case SPOT:
            case FORWARD:
                List<Validator> validatorsSpotForward = Arrays.asList(valueDateTradeDateValidator,
                        valueDateWeekendValidator, counterpartyValidator, currencyPairValidator);
                executor = new ValidationExecutor(validatorsSpotForward, tradeRequiredFieldsValidator);
                break;
            case VANILLA_OPTION:
                List<Validator> validatorsOption = Arrays.asList(valueDateTradeDateValidator, valueDateWeekendValidator,
                        counterpartyValidator, currencyPairValidator, americanOptionExerciseStartDateValidator,
                        expireDateBeforeDeliveryDateValidator, premiumDateBeforeDeliveryDateValidator);
                executor = new ValidationExecutor(validatorsOption, optionRequiredFieldsValidator);
                break;
            default:
                executor = new ValidationExecutor(Collections.emptyList(), null);
        }

        return executor;
    }

    public void setAmericanOptionExerciseStartDateValidator(Validator americanOptionExerciseStartDateValidator) {
        this.americanOptionExerciseStartDateValidator = americanOptionExerciseStartDateValidator;
    }

    public void setCounterpartyValidator(Validator counterpartyValidator) {
        this.counterpartyValidator = counterpartyValidator;
    }

    public void setCurrencyPairValidator(Validator currencyPairValidator) {
        this.currencyPairValidator = currencyPairValidator;
    }

    public void setExpireDateBeforeDeliveryDateValidator(Validator expireDateBeforeDeliveryDateValidator) {
        this.expireDateBeforeDeliveryDateValidator = expireDateBeforeDeliveryDateValidator;
    }

    public void setPremiumDateBeforeDeliveryDateValidator(Validator premiumDateBeforeDeliveryDateValidator) {
        this.premiumDateBeforeDeliveryDateValidator = premiumDateBeforeDeliveryDateValidator;
    }

    public void setValueDateTradeDateValidator(Validator valueDateTradeDateValidator) {
        this.valueDateTradeDateValidator = valueDateTradeDateValidator;
    }

    public void setValueDateWeekendValidator(Validator valueDateWeekendValidator) {
        this.valueDateWeekendValidator = valueDateWeekendValidator;
    }
}
