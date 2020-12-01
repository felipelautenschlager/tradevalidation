package com.felipelauten.tradevalidation.business;

import com.felipelauten.tradevalidation.dto.Trade;
import com.felipelauten.tradevalidation.dto.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationExecutorFactoryTest {

    private ValidationExecutorFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ValidationExecutorFactory();
        factory.setAmericanOptionExerciseStartDateValidator(new ValidatorStub("AmericanOptionExerciseStartDateValidator"));
        factory.setCounterpartyValidator(new ValidatorStub("CounterpartyValidator"));
        factory.setCurrencyPairValidator(new ValidatorStub("CurrencyPairValidator"));
        factory.setExpireDateBeforeDeliveryDateValidator(new ValidatorStub("ExpireDateBeforeDeliveryDateValidator"));
        factory.setPremiumDateBeforeDeliveryDateValidator(new ValidatorStub("PremiumDateBeforeDeliveryDateValidator"));
        factory.setValueDateTradeDateValidator(new ValidatorStub("valueDateTradeDateValidator"));
        factory.setValueDateWeekendValidator(new ValidatorStub("ValueDateWeekendValidator"));
    }

    @Test
    void getValidationExecutorForSpot() {
        // given
        Trade trade = new Trade();
        trade.setType(Type.SPOT);

        // when
        ValidationExecutor result = factory.getValidationExecutor(trade);

        // then
        assertNotNull(result);
        assertEquals(4, result.getValidators().size());
    }

    @Test
    void getValidationExecutorForForward() {
        // given
        Trade trade = new Trade();
        trade.setType(Type.FORWARD);

        // when
        ValidationExecutor result = factory.getValidationExecutor(trade);

        // then
        assertNotNull(result);
        assertEquals(4, result.getValidators().size());
    }

    @Test
    void getValidationExecutorForVanillaOption() {
        // given
        Trade trade = new Trade();
        trade.setType(Type.VANILLA_OPTION);

        // when
        ValidationExecutor result = factory.getValidationExecutor(trade);

        // then
        assertNotNull(result);
        assertEquals(7, result.getValidators().size());
    }
}