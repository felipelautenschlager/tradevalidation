package com.felipelauten.tradevalidation.dto;

import com.felipelauten.tradevalidation.dto.enums.Direction;
import com.felipelauten.tradevalidation.dto.enums.Strategy;
import com.felipelauten.tradevalidation.dto.enums.Style;
import com.felipelauten.tradevalidation.dto.enums.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Trade implements Serializable {

    private Type type;    // Trade type

    // Spot and Forward trades
    private String customer;
    private String ccyPair;
    private Direction direction;
    private LocalDate tradeDate;
    private BigDecimal amount1;
    private BigDecimal amount2;
    private float rate;
    private LocalDate valueDate;
    private String legalEntity;
    private String trader;

    // VanillaOption trades
    private Style style;
    private Strategy strategy;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private String payCcy;
    private LocalDate excerciseStartDate;
    private float premium;
    private String premiumCcy;
    private String premiumType;
    private LocalDate premiumDate;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public void setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public BigDecimal getAmount1() {
        return amount1;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public void setAmount2(BigDecimal amount2) {
        this.amount2 = amount2;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getExcerciseStartDate() {
        return excerciseStartDate;
    }

    public void setExcerciseStartDate(LocalDate excerciseStartDate) {
        this.excerciseStartDate = excerciseStartDate;
    }

    public String getPayCcy() {
        return payCcy;
    }

    public void setPayCcy(String payCcy) {
        this.payCcy = payCcy;
    }

    public float getPremium() {
        return premium;
    }

    public void setPremium(float premium) {
        this.premium = premium;
    }

    public String getPremiumCcy() {
        return premiumCcy;
    }

    public void setPremiumCcy(String premiumCcy) {
        this.premiumCcy = premiumCcy;
    }

    public String getPremiumType() {
        return premiumType;
    }

    public void setPremiumType(String premiumType) {
        this.premiumType = premiumType;
    }

    public LocalDate getPremiumDate() {
        return premiumDate;
    }

    public void setPremiumDate(LocalDate premiumDate) {
        this.premiumDate = premiumDate;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "type=" + type +
                ", customer='" + customer + '\'' +
                ", tradeDate=" + tradeDate +
                ", amount1=" + amount1 +
                ", amount2=" + amount2 +
                ", rate=" + rate +
                '}';
    }
}
