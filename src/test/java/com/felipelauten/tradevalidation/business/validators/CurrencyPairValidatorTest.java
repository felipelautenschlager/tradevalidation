package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyPairValidatorTest {

    private CurrencyPairValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CurrencyPairValidator();
    }

    @Test
    void validateOk() {
        // given
        Trade trade = new Trade();
        trade.setCcyPair("USDEUR");

        // when
        String result = validator.validate(trade);

        // then
        assertNull(result);
    }

    @Test
    void validateFirstCurrencyNotOk() {
        // given
        Trade trade = new Trade();
        trade.setCcyPair("USGEUR");

        // when
        String result = validator.validate(trade);

        // then
        assertNotNull(result);
        assertEquals("Currency Pair USGEUR is invalid.", result);
    }

    @Test
    void validateSecondCurrencyNotOk() {
        // given
        Trade trade = new Trade();
        trade.setCcyPair("USDEUZ");

        // when
        String result = validator.validate(trade);

        // then
        assertNotNull(result);
        assertEquals("Currency Pair USDEUZ is invalid.", result);
    }
}