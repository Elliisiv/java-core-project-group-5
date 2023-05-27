package com.telegramBot.User;
import lombok.Data;

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
}
