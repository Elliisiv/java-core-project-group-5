package com.telegramBot.bank;

public class CurrencyEnumFormatter {
    public CurrencyEnum getCurrencyEnumValue(String enam) {
        switch (enam) {
            case "EUR":
                return CurrencyEnum.EUR;
            case "UAH":
                return CurrencyEnum.UAH;
            case "USD":
                return CurrencyEnum.USD;
            case "GBP":
                return CurrencyEnum.GBP;
            case "PLN":
                return CurrencyEnum.PLN;
        }

        throw new IllegalArgumentException("We don't know enam for " + enam);
    }
}
