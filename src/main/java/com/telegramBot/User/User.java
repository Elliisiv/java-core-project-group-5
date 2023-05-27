package com.telegramBot.User;
import lombok.Data;

import java.util.Arrays;

@Data
public class User {
    private long chatId;
    private String bank;
    private String[] currencies;
    //замінити на ліст?
    private int rounding;
    private String time;

    public User(long chatId, String bank, String[] currencies, int rounding, String time) {
        this.chatId = chatId;
        this.bank = bank;
        this.currencies = currencies;
        this.rounding = rounding;
        this.time = time;
    }

    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", bank='" + bank + '\'' +
                ", currencies=" + Arrays.toString(currencies) +
                ", rounding=" + rounding +
                ", time='" + time + '\'' +
                '}';
    }
}