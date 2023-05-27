package com.telegramBot.telegram.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class BankSetting {
    public static ReplyKeyboardMarkup getBank() {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getBankButtons());

        return replyMarkup;
    }

    private static List<KeyboardRow> getBankButtons() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("НБУ"));
        row1.add(new KeyboardButton("ПриватБанк"));
        row1.add(new KeyboardButton("Монобанк"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Назад"));

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(row1);
        keyboardRows.add(row2);

        return keyboardRows;
    }
}
