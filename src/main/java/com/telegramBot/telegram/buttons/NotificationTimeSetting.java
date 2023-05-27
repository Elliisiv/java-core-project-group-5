package com.telegramBot.telegram.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class NotificationTimeSetting {
    public static ReplyKeyboardMarkup getNotificationTime() {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getNotificationTimeButtons());

        return replyMarkup;
    }

    private static List<KeyboardRow> getNotificationTimeButtons() {
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("9"));
        row1.add(new KeyboardButton("10"));
        row1.add(new KeyboardButton("11"));
        row1.add(new KeyboardButton("12"));
        row1.add(new KeyboardButton("13"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("14"));
        row2.add(new KeyboardButton("15"));
        row2.add(new KeyboardButton("16"));
        row2.add(new KeyboardButton("17"));
        row2.add(new KeyboardButton("18"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Вимкнути повідомлення"));

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("Назад"));

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);

        return keyboard;
    }
}
