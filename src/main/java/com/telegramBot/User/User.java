package com.telegramBot.User;
import lombok.Data;

import java.util.Arrays;

@Data
public class User {
    private long chatId;
    private String [] banks;
    private String[] currencies;
    private int rounding;
    private String time;
    
     ///////////////////////////////////////////////
    // Ira.Y.
    public long getChatId() {
        return chatId;
    }
    ///////////////////////////////////////////////

    public User(long chatId, String[] banks, String[] currencies, int rounding, String time) {
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
                ", bank='" + bank + '\'' +
                ", currencies=" + Arrays.toString(currencies) +
                ", rounding=" + rounding +
                ", time='" + time + '\'' +
                '}';
    }
}
