package com.telegramBot.User;
import lombok.Data;

import java.util.Arrays;


public class User {
    private long chatId;
    private String [] banks;
    private String[] currencies;
    private int rounding;
    private String time;
    
    public long getChatId() {
        return chatId;
    }


    public User(long chatId, String banks [], String[] currencies, int rounding, String time) {
        this.chatId = chatId;
        this.banks = banks;
        this.currencies = currencies;
        this.rounding = rounding;
        this.time = time;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String[] getBanks() {
        return banks;
    }

    public void setBanks(String[] banks) {
        this.banks = banks;
    }

    public String[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String[] currencies) {
        this.currencies = currencies;
    }

    public int getRounding() {
        return rounding;
    }

    public void setRounding(int rounding) {
        this.rounding = rounding;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
                "chatId=" + chatId +
                ", bank='" + Arrays.toString(banks) + '\'' +
                ", currencies=" + Arrays.toString(currencies) +
                ", rounding=" + rounding +
                ", time='" + time + '\'' +
                '}';
    }
}
