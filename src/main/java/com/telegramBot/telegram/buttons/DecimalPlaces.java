package com.telegramBot.telegram.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class DecimalPlaces {
    public static ReplyKeyboardMarkup getDecimalPlaces() {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getDecimalPlacesButtons());

        return replyMarkup;
    }

    private static List<KeyboardRow> getDecimalPlacesButtons() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("2"));
        row1.add(new KeyboardButton("3"));
        row1.add(new KeyboardButton("4"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Назад"));

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(row1);
        keyboardRows.add(row2);

        return keyboardRows;
    }
}
