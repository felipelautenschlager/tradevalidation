package com.felipelauten.tradevalidation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TradeValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldProcessListOfTrades() throws Exception {
        // given
        String request = "[{\"customer\": \"YODA1\",\"ccyPair\": \"EURUSZ\",\"type\": \"Spot\",\"direction\": " +
                "\"BUY\",\"tradeDate\": \"2020-08-11\",\"amount1\": 1000000.00,\"amount2\": 1120000.00," +
                "\"rate\": 1.12,\"valueDate\": \"2020-08-15\",\"legalEntity\": \"UBS AG\",\"trader\": " +
                "\"Josef Schoenberger\"}]";

        String expectedResult = "{\"entries\":[{\"trade\":{\"type\":\"Spot\",\"customer\":\"YODA1\",\"ccyPair" +
                "\":\"EURUSZ\",\"direction\":\"BUY\",\"tradeDate\":\"2020-08-11\",\"amount1\":1000000.00," +
                "\"amount2\":1120000.00,\"rate\":1.12,\"valueDate\":\"2020-08-15\",\"legalEntity\":\"UBS AG\"," +
                "\"trader\":\"Josef Schoenberger\",\"style\":null,\"strategy\":null,\"deliveryDate\":null," +
                "\"expiryDate\":null,\"payCcy\":null,\"excerciseStartDate\":null,\"premium\":0.0,\"premiumCcy" +
                "\":null,\"premiumType\":null,\"premiumDate\":null},\"validationErrors\":[\"Value Date [2020-08-15] " +
                "cannot fall on weekend\",\"Currency Pair EURUSZ is invalid.\"],\"result\":\"2 errors found.\"}]}";

        // when/then
        this.mockMvc.perform(post("/trades/validate")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(request)
                                 ).andDo(print())
                                  .andExpect(status().isOk())
                                  .andExpect(content().json(expectedResult));
    }
}
