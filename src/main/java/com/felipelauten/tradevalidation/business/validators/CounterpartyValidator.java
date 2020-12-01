package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component("CounterpartyValidator")
public class CounterpartyValidator implements Validator {

    public static final String DELIMITER = ",";

    @Value("${counterpartyValidator.counterparties}")
    private String counterpartiesString;
    private List<String> counterparties;

    @PostConstruct
    public void init() {
        if (counterpartiesString != null && !counterpartiesString.equals("")) {
            String[] counterpartiesArray = counterpartiesString.split(DELIMITER);
            counterparties = Arrays.asList(counterpartiesArray);
        } else {
            counterparties = Collections.emptyList();
        }
    }

    private static final String VALIDATION_MESSAGE = "Counterparty %s isn't supported.";

    @Override
    public String validate(Trade trade) {
        if (!counterparties.contains(trade.getCustomer())) {
            return String.format(VALIDATION_MESSAGE, trade.getCustomer());
        }

        return null;
    }

    public void setCounterpartiesString(String counterpartiesString) {
        this.counterpartiesString = counterpartiesString;
    }
}
