package com.telegramBot.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyboardLayouts {


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


    public static ReplyKeyboardMarkup getCurrencies() {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getCurrenciesButtons());

        return replyMarkup;
    }

    private static List<KeyboardRow> getCurrenciesButtons() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("USD"));
        row1.add(new KeyboardButton("EUR"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Назад"));

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(row1);
        keyboardRows.add(row2);

        return keyboardRows;
    }


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
