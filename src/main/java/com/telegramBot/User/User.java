package com.telegramBot.User;
import lombok.Data;

import java.util.Arrays;

@Data
public class User {
    private long chatId;
    private boolean privatBank;
    private boolean monoBank;
    private boolean nbuBank;
    private boolean usdCurr;
    private boolean eurCurr;
    private int rounding;
    private String time;

    ///////////////////////////////////////////////
    // Ira.Y.
    public long getChatId() {
        return chatId;
    }
    ///////////////////////////////////////////////

    public User(long chatId, boolean privatBank, boolean monoBank, boolean nbuBank, boolean usdCurr, boolean eurCurr, int rounding, String time) {
        this.chatId = chatId;
        this.privatBank = privatBank;
        this.monoBank = monoBank;
        this.nbuBank = nbuBank;
        this.usdCurr = usdCurr;
        this.eurCurr = eurCurr;
        this.rounding = rounding;
        this.time = time;
    }


    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public boolean isPivatBank() {
        return privatBank;
    }

    public boolean isMonoBank() {
        return monoBank;
    }

    public boolean isNbuBank() {
        return nbuBank;
    }

    public void setPrivatBank(boolean privatBank) {
        this.privatBank = privatBank;
    }

    public void setMonoBank(boolean monoBank) {
        this.monoBank = monoBank;
    }

    public void setNbuBank(boolean nbuBank) {
        this.nbuBank = nbuBank;
    }

    public boolean getUsdCurr() {
        return usdCurr;
    }

    public boolean getEurCurr() {
        return eurCurr;
    }


    public void setUsdCurr(boolean usdCurr) {
        this.usdCurr = usdCurr;
    }

    public void setEurCurr(boolean eurCurr) {
        this.eurCurr = eurCurr;
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
        return "User{" +
                "chatId=" + chatId +
                ", privatBank=" + privatBank +
                ", monoBank=" + monoBank +
                ", nbuBank=" + nbuBank +
                ", usdCurr=" + usdCurr +
                ", eurCurr=" + eurCurr +
                ", rounding=" + rounding +
                ", time='" + time + '\'' +
                '}';
    }

}

//    @Override
//    public String toString() {
//        return "{" +
//                "chatId=" + chatId +
//                ", bank='" + Arrays.toString(banks) + '\'' +
//                ", currencies=" + Arrays.toString(currencies) +
//                ", rounding=" + rounding +
//                ", time='" + time + '\'' +
//                '}';
//    }


//package com.telegramBot.User;
//import lombok.Data;
//
//import java.util.Arrays;
//
//
//public class User {
//    private long chatId;
//    private String [] banks;
//    private String[] currencies;
//    private int rounding;
//    private String time;
//
//     ///////////////////////////////////////////////
//    // Ira.Y.
//    public long getChatId() {
//        return chatId;
//    }
//    ///////////////////////////////////////////////
//
//    public User(long chatId, String banks [], String[] currencies, int rounding, String time) {
//        this.chatId = chatId;
//        this.banks = banks;
//        this.currencies = currencies;
//        this.rounding = rounding;
//        this.time = time;
//    }
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
