package com.felipelauten.tradevalidation.business.service;

import com.felipelauten.tradevalidation.dto.Trade;
import com.felipelauten.tradevalidation.dto.ValidationBag;

import java.util.List;

public interface TradeAnalysisService {

    ValidationBag processValidation(List<Trade> tradeList);

}
