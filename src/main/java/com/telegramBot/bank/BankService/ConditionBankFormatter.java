package com.telegramBot.bank.BankService;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class ConditionBankFormatter {

    private boolean privatBank = false;
    private boolean monoBank = false;
    private boolean nbuBank = false;
    private int condition = 0;
    public ConditionBankFormatter(long chatId){

        UserSettings userSettings = new UserSettings();
        User user = userSettings.getUserSettingsByChatId(chatId);

        String [] banks = user.getBanks();

        for (String bank: banks ){

            if (bank.equals("Privat")){
                this.privatBank = true;
            }
//             if (bank.equals("monoBank")){
//                 this.privatBank = true;
//             }

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