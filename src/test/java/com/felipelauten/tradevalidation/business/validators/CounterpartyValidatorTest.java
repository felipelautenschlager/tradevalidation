package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterpartyValidatorTest {

    private CounterpartyValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CounterpartyValidator();
        validator.setCounterpartiesString("YODA1,YODA2");
        validator.init();
    }

    @Test
    void validateOk() {
        // given
        Trade trade = new Trade();
        trade.setCustomer("YODA1");

        // when
        String result = validator.validate(trade);

        // then
        assertNull(result);
    }

    @Test
    void validateNotOk() {
        // given
        Trade trade = new Trade();
        trade.setCustomer("NOTOK");

        // when
        String result = validator.validate(trade);

        // then
        assertNotNull(result);
        assertEquals("Counterparty NOTOK isn't supported.", result);
    }
}