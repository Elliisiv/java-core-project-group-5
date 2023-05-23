package com.telegramBot.User;
import lombok.Data;

@Data
public class User {
    private long chatId;
    private String bank;
    private String[] currencies;
    private int rounding;
    private String time;

    public User(long chatId, String bank, String[] currencies, int rounding, String time) {
        this.chatId = chatId;
        this.bank = bank;
        this.currencies = currencies;
        this.rounding = rounding;
        this.time = time;

    }
}