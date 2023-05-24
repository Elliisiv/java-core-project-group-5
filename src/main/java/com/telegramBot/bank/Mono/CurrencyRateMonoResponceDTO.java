package com.telegramBot.bank.Mono;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyRateMonoResponceDTO {
    private int currencyCodeA;
    private int currencyCodeB;
    private String date;
    private BigDecimal rateBuy;
    private BigDecimal rateCross;
    private BigDecimal rateSell;

    @Override
    public String toString() {
        return "{" +
                "currencyCodeA=" + currencyCodeA +
                ", currencyCodeB=" + currencyCodeB +
                ", date='" + date + '\'' +
                ", rateBuy=" + rateBuy +
                ", rateCross=" + rateCross +
                ", rateSell=" + rateSell +
                '}';
    }
}
