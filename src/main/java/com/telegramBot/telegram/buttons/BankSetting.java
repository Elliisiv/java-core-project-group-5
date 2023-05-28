package com.telegramBot.telegram.buttons;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
import com.telegramBot.bank.BankEnum;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class BankSetting {
    public static ReplyKeyboardMarkup getBank(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getBankButtons(chatId));

        return replyMarkup;
    }

    private static List<KeyboardRow> getBankButtons(long chatId) {

        UserSettings userSettings = new UserSettings();
        User user = userSettings.getUserSettingsByChatId(chatId);
        BankEnum[] banks = user.getBanks();
        boolean[] bankContainer = {false,false,false};
        for (BankEnum  bank: banks) {
            if(bank == BankEnum.PRIVAT) {
                bankContainer[0] = true;
            } else if (bank == BankEnum.MONO) {
                bankContainer[1] = true;
            } else if (bank == BankEnum.NBU) {
                bankContainer[2] = true;
            }
        }

        KeyboardRow row1 = new KeyboardRow();
        if(!bankContainer[0]&&!bankContainer[1]&&!bankContainer[2]) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(!bankContainer[0]&&!bankContainer[1]&&bankContainer[2]) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(!bankContainer[0]&&bankContainer[1]&&!bankContainer[2]) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(!bankContainer[0]&&bankContainer[1]&&bankContainer[2]) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(bankContainer[0]&&!bankContainer[1]&&!bankContainer[2]) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(bankContainer[0]&&!bankContainer[1]&&bankContainer[2]) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(bankContainer[0]&&bankContainer[1]&&!bankContainer[2]) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(bankContainer[0]&&bankContainer[1]&&bankContainer[2]) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Назад"));

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(row1);
        keyboardRows.add(row2);

        return keyboardRows;
    }
}
