package com.telegramBot.telegram.buttons;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
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

        KeyboardRow row1 = new KeyboardRow();
        if(!user.isPrivatBank()&&!user.isMonoBank()&&user.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(!user.isPrivatBank()&&user.isMonoBank()&&!user.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(!user.isPrivatBank()&&user.isMonoBank()&&user.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(user.isPrivatBank()&&!user.isMonoBank()&&!user.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(user.isPrivatBank()&&!user.isMonoBank()&&user.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(user.isPrivatBank()&&user.isMonoBank()&&!user.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(user.isPrivatBank()&&user.isMonoBank()&&user.isNbuBank()) {
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
