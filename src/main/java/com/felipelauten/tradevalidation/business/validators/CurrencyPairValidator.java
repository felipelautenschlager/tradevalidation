package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.Set;
import java.util.stream.Collectors;

@Component("CurrencyPairValidator")
public class CurrencyPairValidator implements Validator {

    private static final String VALIDATION_MESSAGE = "Currency Pair %s is invalid.";

    private Set<String> currencyCodes;

    public CurrencyPairValidator() {
        Set<Currency> currencies = Currency.getAvailableCurrencies();
        currencyCodes = currencies.stream().map(c -> c.getCurrencyCode())
                                           .collect(Collectors.toSet());
    }

    @Override
    public String validate(Trade trade) {
        String currencyPair = trade.getCcyPair();
        String currency1 = currencyPair.substring(0, 3);
        String currency2 = currencyPair.substring(3, 6);

        if (!isValidCurrency(currency1) || !isValidCurrency(currency2)) {
            return String.format(VALIDATION_MESSAGE, currencyPair);
        }

        return null;
    }

    private boolean isValidCurrency(String currency) {
        return currencyCodes.contains(currency);
    }
}
