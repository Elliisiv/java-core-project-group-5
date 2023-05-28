package com.telegramBot.User;
import com.telegramBot.bank.BankEnum;
import lombok.Data;

import java.util.Arrays;

@Data
public class User {
    private long chatId;
    private BankEnum[] banks;
    private String[] currencies;
    private int rounding;
    private String time;
    
     ///////////////////////////////////////////////
    // Ira.Y.
    public long getChatId() {
        return chatId;
    }
    ///////////////////////////////////////////////

    public User(long chatId, BankEnum banks [], String[] currencies, int rounding, String time) {
        this.chatId = chatId;
        this.banks = banks;
        this.currencies = currencies;
        this.rounding = rounding;
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
                "chatId=" + chatId +
                ", bank='" + banks + '\'' +
                ", currencies=" + Arrays.toString(currencies) +
                ", rounding=" + rounding +
                ", time='" + time + '\'' +
                '}';
    }
}
