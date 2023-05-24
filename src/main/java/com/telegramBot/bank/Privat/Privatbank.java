package com.telegramBot.bank.Privat;

public class Privatbank {

    private String baseCurrency;
    private String currency;
    private String purchaseRate;
    private String saleRate;


    public void Privatbank(String baseCurrency, String currency, String purchaseRate, String saleRate){
        this.baseCurrency = baseCurrency;
        this.currency = currency;
        this.purchaseRate = purchaseRate;
        this.saleRate = saleRate;

    }

    public String get_base_currency() {
        return baseCurrency;
    }
    public String get_currency() {
        return currency;
    }
    public String get_purchase() {
        return purchaseRate;
    }

    public String get_saleRate() {
        return saleRate;
    }
}
