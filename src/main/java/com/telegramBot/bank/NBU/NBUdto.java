package com.telegramBot.bank.NBU;

import com.telegramBot.bank.CurrencyEnum;
import lombok.Data;

@Data
public class NBUdto {
    private String r030;
    private String txt;
    private double rate;
    private CurrencyEnum cc;
    private String exchangedate;
    
    ///////////////////////////////////////////////
    // Ira.Y.
    public CurrencyEnum getCc() {
        return cc;
    }
    public double getRate() {
        return rate;
    }
    ///////////////////////////////////////////////
}
