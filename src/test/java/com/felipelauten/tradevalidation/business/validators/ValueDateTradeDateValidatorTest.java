package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValueDateTradeDateValidatorTest {

    private ValueDateTradeDateValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ValueDateTradeDateValidator();
    }

    @Test
    void validateOk() {
        // given
        Trade testTrade = new Trade();
        testTrade.setTradeDate(LocalDate.of(2020, 11, 26));
        testTrade.setValueDate(LocalDate.of(2020, 11, 28));

        // when
        String result = validator.validate(testTrade);

        // then
        assertNull(result);
    }

    @Test
    void validateNotOk() {
        // given
        Trade testTrade = new Trade();
        testTrade.setTradeDate(LocalDate.of(2020, 11, 28));
        testTrade.setValueDate(LocalDate.of(2020, 11, 26));

        // when
        String result = validator.validate(testTrade);

        // then
        assertNotNull(result);
        assertEquals("Value Date [2020-11-26] cannot be before Trade Date [2020-11-28]", result);
    }
}