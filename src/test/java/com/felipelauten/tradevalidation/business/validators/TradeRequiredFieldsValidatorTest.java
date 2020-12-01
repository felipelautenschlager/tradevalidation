package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TradeRequiredFieldsValidatorTest {

    private TradeRequiredFieldsValidator validator;

    @BeforeEach
    void setUp() {
        validator = new TradeRequiredFieldsValidator();
    }

    @Test
    void allFieldsOkShouldReturnTrue() {
        // given
        Trade trade = new Trade();
        trade.setValueDate(LocalDate.of(2020, 11, 29));
        trade.setTradeDate(LocalDate.of(2020, 11, 29));
        trade.setCustomer("YODA1");
        trade.setCcyPair("EURUSD");

        // when
        boolean result = validator.isValid(trade);

        // then
        assertTrue(result);
    }

    @Test
    void missingValueDateShouldReturnFalse() {
        // given
        Trade trade = new Trade();
        trade.setTradeDate(LocalDate.of(2020, 11, 29));
        trade.setCustomer("YODA1");
        trade.setCcyPair("EURUSD");

        // when
        boolean result = validator.isValid(trade);

        // then
        assertFalse(result);
    }

    @Test
    void missingTradeDateShouldReturnFalse() {
        // given
        Trade trade = new Trade();
        trade.setValueDate(LocalDate.of(2020, 11, 29));
        trade.setCustomer("YODA1");
        trade.setCcyPair("EURUSD");

        // when
        boolean result = validator.isValid(trade);

        // then
        assertFalse(result);
    }

    @Test
    void missingCustomerShouldReturnFalse() {
        // given
        Trade trade = new Trade();
        trade.setValueDate(LocalDate.of(2020, 11, 29));
        trade.setTradeDate(LocalDate.of(2020, 11, 29));
        trade.setCcyPair("EURUSD");

        // when
        boolean result = validator.isValid(trade);

        // then
        assertFalse(result);
    }

    @Test
    void missingCcyPairShouldReturnFalse() {
        // given
        Trade trade = new Trade();
        trade.setValueDate(LocalDate.of(2020, 11, 29));
        trade.setTradeDate(LocalDate.of(2020, 11, 29));
        trade.setCustomer("YODA1");

        // when
        boolean result = validator.isValid(trade);

        // then
        assertFalse(result);
    }
}