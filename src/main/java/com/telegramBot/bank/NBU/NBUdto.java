package com.telegramBot.bank.NBU;

import com.telegramBot.bank.BankEnum;
import lombok.Data;

@Data
public class NBUdto {
    private String r030;
    private String txt;
    private double rate;
    private BankEnum cc;
    private String exchangedate;
}
