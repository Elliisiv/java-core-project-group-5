package com.telegramBot.bank;

public class BankEnumFormatter {
    public BankEnum getBankEnumValue(String enam) {
        switch (enam) {
            case "Privat":
                return BankEnum.PRIVAT;
            case "Mono":
                return BankEnum.MONO;
            case "NBU":
                return BankEnum.NBU;
        }

        throw new IllegalArgumentException("We don't know enam for " + enam);
    }
}
