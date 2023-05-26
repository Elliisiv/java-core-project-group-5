package com.telegramBot.bank.Privat;
import com.telegramBot.bank.BankEnum;
import com.telegramBot.bank.BankEnumFormatter;

import java.math.BigDecimal;

public class Privatbank {

    private String baseCurrency;
    private BankEnum currency;
    private BigDecimal purchaseRate;
    private BigDecimal saleRate;


    public void Privatbank(String baseCurrency, String currency, BigDecimal purchaseRate, BigDecimal saleRate){
        this.baseCurrency = baseCurrency;
        BankEnumFormatter bankFormatter = new BankEnumFormatter();
        BankEnum currencyN = bankFormatter.getBankEnumValue(currency);
        this.currency = currencyN;
        this.purchaseRate = purchaseRate;
        this.saleRate = saleRate;

    }

    public String get_base_currency() {
        return baseCurrency;
    }
    public BankEnum get_currency() {
        return currency;
    }
    public BigDecimal get_purchase() {
        return purchaseRate;
    }

    public BigDecimal get_saleRate() {
        return saleRate;
    }
}
