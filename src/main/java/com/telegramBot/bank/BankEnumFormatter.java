package com.telegramBot.bank;

public class BankEnumFormatter {
    public BankEnum getBankEnumValue(String enam) {
        switch (enam) {
            case "EUR":
                return BankEnum.EUR;
            case "UAH":
                return BankEnum.UAH;
            case "USD":
                return BankEnum.USD;
            case "GBP":
                return BankEnum.GBP;
            case "PLN":
                return BankEnum.PLN;
        }

        throw new IllegalArgumentException("We don't know enam for " + enam);
    }
}
