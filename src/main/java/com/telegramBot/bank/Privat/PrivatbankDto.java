package com.telegramBot.bank.Privat;

import com.telegramBot.bank.BankEnum;

public class PrivatbankDto {

    private BankEnum baseCurrency;
    private BankEnum currency;
    private String purchaseRate;
    private String saleRate;


    public PrivatbankDto() {}
    public PrivatbankDto(BankEnum baseCurrency, BankEnum currency, String purchaseRate, String saleRate){
        this.baseCurrency = baseCurrency;
        this.currency = currency;
        this.purchaseRate = purchaseRate;
        this.saleRate = saleRate;
    }

    public BankEnum get_base_currency() {
        return baseCurrency;
    }
    public BankEnum get_currency() {
        return currency;
    }
    public String get_purchase() {
        return purchaseRate;
    }
    public String get_saleRate() {
        return saleRate;
    }

}

