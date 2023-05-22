package com.telegramBot.bank.NBU;

import lombok.Data;

@Data
public class NBUdto {
    private String r030;
    private String txt;
    private double rate;
    private Currency cc;
    private String exchangedate;

    public enum Currency {
        GBP,
        USD,
        EUR,
        PLN,
        UAH
    }
}
