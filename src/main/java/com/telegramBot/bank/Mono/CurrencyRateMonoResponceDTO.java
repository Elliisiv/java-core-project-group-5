package com.telegramBot.bank.Mono;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
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

    public enum Currency {
        GBP,
        USD,
        EUR,
        PLN,
        UAH
    }
}
