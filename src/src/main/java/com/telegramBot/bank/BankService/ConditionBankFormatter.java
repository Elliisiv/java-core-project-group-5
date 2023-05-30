package com.telegramBot.bank.BankService;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;

public class ConditionBankFormatter {

    private boolean privatBank = false;
    private boolean monoBank = false;
    private boolean nbuBank = false;

    public ConditionBankFormatter(long chatId){

        UserSettings userSettings = new UserSettings();
        User user = userSettings.getUserSettingsByChatId(chatId);

        String [] banks = user.getBanks();

        for (String bank: banks ){

            if (bank.equals("Privat")){
                this.privatBank = true;
            }

            // + Ira.Y
            if (bank.equals("Mono")){
                this.monoBank = true;
            }
            // - Ira.Y

            if (bank.equals("NBU")){
                this.nbuBank = true;
            }

        }

    }

    public boolean isPrivatBank() {
        return privatBank;
    }

    public boolean isMonoBank() {
        return monoBank;
    }

    public boolean isNbuBank() {
        return nbuBank;
    }

}