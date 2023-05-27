package com.telegramBot.telegram.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class SettingsKeyboard {
    public static ReplyKeyboardMarkup getSettingsKeyboard() {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getSettingsKeyboardButtons());

        return replyMarkup;
    }

    private static List<KeyboardRow> getSettingsKeyboardButtons() {
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Кількість знаків після коми"));
        row1.add(new KeyboardButton("Банк"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Валюти"));
        row2.add(new KeyboardButton("Час сповіщень"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Прийняти"));
        row3.add(new KeyboardButton("Відхилити"));

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        return keyboard;
    }
}
