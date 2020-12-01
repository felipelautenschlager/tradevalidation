package com.felipelauten.tradevalidation.business;

import com.felipelauten.tradevalidation.business.validators.RequiredFieldsValidator;
import com.felipelauten.tradevalidation.business.validators.Validator;
import com.felipelauten.tradevalidation.dto.Trade;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationExecutorTest {

    @Test
    void executorWithEmptyValidatorListShouldExecute() {
        // given
        ValidationExecutor executor = new ValidationExecutor(null, new AlwaysTrueRequiredFieldsValidatorStub());
        Trade trade = new Trade();

        // when
        List<String> result = executor.execute(trade);

        // then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void executorWithValidatorsAndMissingFieldsShouldReturnMessage() {
        // given
        Validator validator1 = new ValidatorStub("1");
        Validator validator2 = new ValidatorStub("2");
        Validator validator3 = new ValidatorStub("3");
        ValidationExecutor executor = new ValidationExecutor(Arrays.asList(validator1, validator2, validator3),
                new AlwaysFalseRequiredFieldsValidatorStub());
        Trade trade = new Trade();

        // when
        List<String> result = executor.execute(trade);

        // then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Trade is missing the required fields.", result.get(0));
    }

    @Test
    void executorWithValidatorsShouldReturnValidationList() {
        // given
        Validator validator1 = new ValidatorStub("1");
        Validator validator2 = new ValidatorStub("2");
        Validator validator3 = new ValidatorStub("3");
        ValidationExecutor executor = new ValidationExecutor(Arrays.asList(validator1, validator2, validator3),
                new AlwaysTrueRequiredFieldsValidatorStub());
        Trade trade = new Trade();

        // when
        List<String> result = executor.execute(trade);

        // then
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Validated 1", result.get(0));
        assertEquals("Validated 2", result.get(1));
        assertEquals("Validated 3", result.get(2));
    }

    class AlwaysTrueRequiredFieldsValidatorStub implements RequiredFieldsValidator {

        @Override
        public boolean isValid(Trade trade) {
            return true;
        }
    }

    class AlwaysFalseRequiredFieldsValidatorStub implements RequiredFieldsValidator {

        @Override
        public boolean isValid(Trade trade) {
            return false;
        }
    }
}