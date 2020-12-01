package com.felipelauten.tradevalidation.controller;

import com.felipelauten.tradevalidation.business.service.TradeAnalysisService;
import com.felipelauten.tradevalidation.dto.Trade;
import com.felipelauten.tradevalidation.dto.ValidationBag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/trades")
public class TradeValidationController {

    private static final Logger LOGGER = LoggerFactory.getLogger("TradeValidationController");

    @Autowired
    private TradeAnalysisService service;

    @PostMapping("/validate")
    @ResponseStatus(HttpStatus.OK)
    public ValidationBag validateTradeList(@RequestBody ArrayList<Trade> trades) {

        ValidationBag result = service.processValidation(trades);

        return result;
    }
}
