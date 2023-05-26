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
    
    ///////////////////////////////////////////////
    // Ira.Y.
    public int getCurrencyCodeA() {
        return currencyCodeA;
    }

    public int getCurrencyCodeB() {
        return currencyCodeB;
    }

    public BigDecimal getRateBuy() {
        return rateBuy;
    }

    public BigDecimal getRateSell() {
        return rateSell;
    }
    ///////////////////////////////////////////////

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
