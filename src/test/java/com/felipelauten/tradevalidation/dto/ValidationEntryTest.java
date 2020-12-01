package com.felipelauten.tradevalidation.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationEntryTest {

    @Test
    void validationEntryInitializedCorrectly() {
        // given
        Trade trade = new Trade();

        // when
        ValidationEntry entry = new ValidationEntry(trade);

        // then
        assertEquals(trade, entry.getTrade());
        assertNotNull(entry.getValidationErrors());
        assertEquals(0, entry.getValidationErrors().size());
    }

    @Test
    void addValidationErrors() {
        // given
        Trade trade = new Trade();
        List<String> errors = Arrays.asList("Error 1", "Error 2", "Error 3");
        ValidationEntry entry = new ValidationEntry(trade);

        // when
        entry.addValidationErrors(errors);

        // then
        assertNotNull(entry.getValidationErrors());
        assertEquals(3, entry.getValidationErrors().size());
        assertEquals("Error 1", entry.getValidationErrors().get(0));
        assertEquals("Error 2", entry.getValidationErrors().get(1));
        assertEquals("Error 3", entry.getValidationErrors().get(2));
    }

    @Test
    void hasErrorsWithErrors() {
        // given
        Trade trade = new Trade();
        List<String> errors = Arrays.asList("Error 1", "Error 2", "Error 3");
        ValidationEntry entry = new ValidationEntry(trade);
        entry.addValidationErrors(errors);

        // when
        boolean result = entry.hasErrors();

        // then
        assertTrue(result);
    }

    @Test
    void hasErrorsWithoutErrors() {
        // given
        Trade trade = new Trade();
        ValidationEntry entry = new ValidationEntry(trade);

        // when
        boolean result = entry.hasErrors();

        // then
        assertFalse(result);
    }

    @Test
    void getResultWithErrors() {
        // given
        Trade trade = new Trade();
        List<String> errors = Arrays.asList("Error 1", "Error 2", "Error 3");
        ValidationEntry entry = new ValidationEntry(trade);
        entry.addValidationErrors(errors);

        // when
        String result = entry.getResult();

        // then
        assertNotNull(result);
        assertEquals("3 errors found.", result);
    }

    @Test
    void getResultWithoutErrors() {
        // given
        Trade trade = new Trade();
        ValidationEntry entry = new ValidationEntry(trade);

        // when
        String result = entry.getResult();

        // then
        assertNotNull(result);
        assertEquals("No errors found.", result);
    }
}