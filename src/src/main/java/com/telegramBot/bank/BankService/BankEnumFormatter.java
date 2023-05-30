package com.telegramBot.bank.BankService;



public class BankEnumFormatter {
    public BankEnum getBankEnumValue(String enam) {
        switch (enam) {
            case "Privat":
                return BankEnum.Privat;
            case "Mono":
                return BankEnum.Mono;
            case "NBU":
                return BankEnum.NBU;
        }

        throw new IllegalArgumentException("We don't know enam for " + enam);
    }
}
