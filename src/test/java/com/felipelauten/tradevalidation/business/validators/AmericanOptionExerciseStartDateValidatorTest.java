package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.enums.Style;
import com.felipelauten.tradevalidation.dto.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AmericanOptionExerciseStartDateValidatorTest {

    private AmericanOptionExerciseStartDateValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AmericanOptionExerciseStartDateValidator();
    }

    @Test
    void validationOfEuropeanOptionShouldNotOccur() {
        // given
        Trade trade = new Trade();
        trade.setStyle(Style.EUROPEAN);

        // when
        String result = validator.validate(trade);

        // then
        assertNull(result);
    }

    @Test
    void validateAmericanOptionOk() {
        // given
        Trade trade = new Trade();
        trade.setStyle(Style.AMERICAN);
        trade.setTradeDate(LocalDate.of(2020, 11, 26));
        trade.setExcerciseStartDate(LocalDate.of(2020, 11, 28));
        trade.setExpiryDate(LocalDate.of(2020, 11, 30));

        // when
        String result = validator.validate(trade);

        // then
        assertNull(result);
    }

    @Test
    void validateAmericanOptionNotOkExcerciseStartDateBeforeTradeDate() {
        // given
        Trade trade = new Trade();
        trade.setStyle(Style.AMERICAN);
        trade.setTradeDate(LocalDate.of(2020, 11, 26));
        trade.setExcerciseStartDate(LocalDate.of(2020, 11, 25));
        trade.setExpiryDate(LocalDate.of(2020, 11, 30));

        // when
        String result = validator.validate(trade);

        // then
        assertNotNull(result);
        assertEquals("Excercise Start Date [2020-11-25] should be in between Trade Date and " +
                "Expiry Date", result);
    }

    @Test
    void validateAmericanOptionNotOkExcerciseStartDateAfterExpiryDate() {
        // given
        Trade trade = new Trade();
        trade.setStyle(Style.AMERICAN);
        trade.setTradeDate(LocalDate.of(2020, 11, 26));
        trade.setExcerciseStartDate(LocalDate.of(2020, 12, 1));
        trade.setExpiryDate(LocalDate.of(2020, 11, 30));

        // when
        String result = validator.validate(trade);

        // then
        assertNotNull(result);
        assertEquals("Excercise Start Date [2020-12-01] should be in between Trade Date and " +
                "Expiry Date", result);
    }
}