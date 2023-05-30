package com.telegramBot.telegram.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MainKeyboard {

    public static ReplyKeyboardMarkup getMainKeyboard() {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getMainKeyboardButtons());

        return replyMarkup;
    }

    private static List<KeyboardRow> getMainKeyboardButtons() {
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Отримати інфо"));
        row1.add(new KeyboardButton("Налаштування"));

        keyboard.add(row1);

        return keyboard;
    }
}
