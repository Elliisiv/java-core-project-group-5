package com.telegramBot.User;
import lombok.Data;

@Data
public class User {
    private long chatId;
    //private Bank bank;
    private String currency;


//    public User(String chatId, Bank bank, String currency) {
//        this.chatId = chatId;
//        this.bank = bank;
//        this.currency = currency;
//    }
}