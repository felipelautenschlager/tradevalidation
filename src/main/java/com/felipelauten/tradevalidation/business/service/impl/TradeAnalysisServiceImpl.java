package com.felipelauten.tradevalidation.business.service.impl;

import com.felipelauten.tradevalidation.business.ValidationExecutor;
import com.felipelauten.tradevalidation.business.ValidationExecutorFactory;
import com.felipelauten.tradevalidation.business.service.TradeAnalysisService;
import com.felipelauten.tradevalidation.dto.Trade;
import com.felipelauten.tradevalidation.dto.ValidationBag;
import com.felipelauten.tradevalidation.dto.ValidationEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeAnalysisServiceImpl implements TradeAnalysisService {

    private static final Logger LOGGER = LoggerFactory.getLogger("TradeAnalysisServiceImpl");

    @Autowired
    private ValidationExecutorFactory factory;

    @Override
    public ValidationBag processValidation(List<Trade> tradeList) {
        LOGGER.debug("Starting validation of tradeList");
        ValidationBag result = new ValidationBag();

        if (tradeList != null) {
            for (Trade trade : tradeList) {
                ValidationEntry entry = new ValidationEntry(trade);
                ValidationExecutor executor = factory.getValidationExecutor(trade);
                List<String> errors = executor.execute(trade);
                entry.addValidationErrors(errors);

                result.addValidationEntry(entry);
            }
        }
        return result;
    }

    public void setFactory(ValidationExecutorFactory factory) {
        this.factory = factory;
    }
}
