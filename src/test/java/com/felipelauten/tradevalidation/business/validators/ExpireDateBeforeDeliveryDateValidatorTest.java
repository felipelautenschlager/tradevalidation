package com.felipelauten.tradevalidation.business.validators;

import com.felipelauten.tradevalidation.dto.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpireDateBeforeDeliveryDateValidatorTest {

    private ExpireDateBeforeDeliveryDateValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ExpireDateBeforeDeliveryDateValidator();
    }

    @Test
    void validateOk() {
        // given
        Trade trade = new Trade();
        trade.setExpiryDate(LocalDate.of(2020, 11, 28));
        trade.setDeliveryDate(LocalDate.of(2020, 12, 1));

        // when
        String result = validator.validate(trade);

        // then
        assertNull(result);
    }

    @Test
    void validateNotOk() {
        // given
        Trade trade = new Trade();
        trade.setExpiryDate(LocalDate.of(2020, 12, 2));
        trade.setDeliveryDate(LocalDate.of(2020, 12, 1));

        // when
        String result = validator.validate(trade);

        // then
        assertNotNull(result);
        assertEquals("Expiry date [2020-12-02] should be before Delivery Date [2020-12-01]", result);
    }
}