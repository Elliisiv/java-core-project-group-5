package com.telegramBot.User;
import lombok.Data;

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
