package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import com.felipelauten.tradevalidation.dto.enums.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OptionRequiredFieldsValidatorTest {

    private OptionRequiredFieldsValidator validator;

    @BeforeEach
    void setUp() {
        validator = new OptionRequiredFieldsValidator();
    }

    @Test
    void allFieldsOkShouldReturnTrue() {
        // given
        Trade trade = new Trade();
        trade.setValueDate(LocalDate.of(2020, 11, 29));
        trade.setTradeDate(LocalDate.of(2020, 11, 29));
        trade.setCustomer("YODA1");
        trade.setCcyPair("EURUSD");
        trade.setExcerciseStartDate(LocalDate.of(2020, 11, 29));
        trade.setExpiryDate(LocalDate.of(2020, 11, 29));
        trade.setPremiumDate(LocalDate.of(2020, 11, 29));

        // when
        boolean result = validator.isValid(trade);

        // then
        assertTrue(result);
    }

    @Test
    void missingExcerciseStartDateShouldReturnFalse() {
        // given
        Trade trade = new Trade();
        trade.setValueDate(LocalDate.of(2020, 11, 29));
        trade.setTradeDate(LocalDate.of(2020, 11, 29));
        trade.setCustomer("YODA1");
        trade.setCcyPair("EURUSD");
        trade.setExpiryDate(LocalDate.of(2020, 11, 29));
        trade.setPremiumDate(LocalDate.of(2020, 11, 29));
        trade.setStyle(Style.AMERICAN);

        // when
        boolean result = validator.isValid(trade);

        // then
        assertFalse(result);
    }

    @Test
    void missingExpiryDateShouldReturnFalse() {
        // given
        Trade trade = new Trade();
        trade.setValueDate(LocalDate.of(2020, 11, 29));
        trade.setTradeDate(LocalDate.of(2020, 11, 29));
        trade.setCustomer("YODA1");
        trade.setCcyPair("EURUSD");
        trade.setExcerciseStartDate(LocalDate.of(2020, 11, 29));
        trade.setPremiumDate(LocalDate.of(2020, 11, 29));

        // when
        boolean result = validator.isValid(trade);

        // then
        assertFalse(result);
    }

    @Test
    void missingPremiumDateShouldReturnFalse() {
        // given
        Trade trade = new Trade();
        trade.setValueDate(LocalDate.of(2020, 11, 29));
        trade.setTradeDate(LocalDate.of(2020, 11, 29));
        trade.setCustomer("YODA1");
        trade.setCcyPair("EURUSD");
        trade.setExcerciseStartDate(LocalDate.of(2020, 11, 29));
        trade.setExpiryDate(LocalDate.of(2020, 11, 29));

        // when
        boolean result = validator.isValid(trade);

        // then
        assertFalse(result);
    }
}