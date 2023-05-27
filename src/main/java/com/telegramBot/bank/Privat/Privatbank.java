package com.telegramBot.bank.Privat;
import com.telegramBot.bank.BankEnum;
import com.telegramBot.bank.BankEnumFormatter;
import com.telegramBot.bank.CurrencyEnum;
import com.telegramBot.bank.CurrencyEnumFormatter;

import java.math.BigDecimal;

public class Privatbank {

    private String baseCurrency;
    private CurrencyEnum currency;
    private BigDecimal purchaseRate;
    private BigDecimal saleRate;


    public void Privatbank(String baseCurrency, String currency, BigDecimal purchaseRate, BigDecimal saleRate){
        this.baseCurrency = baseCurrency;
        CurrencyEnumFormatter currensyFormatter = new CurrencyEnumFormatter();
        CurrencyEnum currencyN = currensyFormatter.getCurrencyEnumValue(currency);
        this.currency = currencyN;
        this.purchaseRate = purchaseRate;
        this.saleRate = saleRate;

    }

    public String get_base_currency() {
        return baseCurrency;
    }
    public CurrencyEnum get_currency() {
        return currency;
    }
    public BigDecimal get_purchase() {
        return purchaseRate;
    }

    public BigDecimal get_saleRate() {
        return saleRate;
    }
}
