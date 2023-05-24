package com.telegramBot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class CurrencyTelegramBot extends TelegramLongPollingBot {

    private final String username;
    private final String token;

    public CurrencyTelegramBot(String username, String token) {

        this.username = username;
        this.token = token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();

            switch (messageText) {
                case "/start":
                    sendWelcomeMessage(chatId);
                    sendMainKeyboard(chatId);
                    break;
            }

            switch (messageText) {
                case "Отримати інфо" -> sendInfo(chatId);
                case "Налаштування" -> sendSettingsKeyboard(chatId);
                case "Кількість знаків після коми" -> handleDecimalPlacesSetting(chatId);
                case "Банк" -> handleBankSetting(chatId);
                case "Валюти" -> handleCurrenciesSetting(chatId);
                case "Час оповіщень" -> handleNotificationTimeSetting(chatId);
                case "Назад" -> sendSettingsKeyboard(chatId);
                //case "Головне меню" -> sendMainKeyboard(chatId);
            }
        }
    }

    private void sendWelcomeMessage(long chatId) {
        String welcomeMessage = "Ласкаво просимо. Цей бот допоможе відслідковувати актуальні курси валют.";
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(welcomeMessage);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMainKeyboard(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Головне меню");

        ReplyKeyboardMarkup replyMarkup = getMainKeyboard();
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendInfo(long chatId) {

        String currencyInfo = "Курс валют: ...";
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(currencyInfo);
        message.setReplyMarkup(getMainKeyboard());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendSettingsKeyboard(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);

        KeyboardButton[][] buttons = getSettingsButtons();
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        for (KeyboardButton[] buttonRow : buttons) {
            KeyboardRow keyboardRow = new KeyboardRow();
            Collections.addAll(keyboardRow, buttonRow);
            keyboardRows.add(keyboardRow);
        }

        replyMarkup.setKeyboard(keyboardRows);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Налаштування");
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private KeyboardButton[][] getSettingsButtons() {
        KeyboardButton[][] buttons = new KeyboardButton[2][2];

        KeyboardButton button1 = new KeyboardButton("Кількість знаків після коми");
        KeyboardButton button2 = new KeyboardButton("Банк");
        KeyboardButton button3 = new KeyboardButton("Валюти");
        KeyboardButton button4 = new KeyboardButton("Час оповіщень");
        //KeyboardButton button5 = new KeyboardButton("Головне меню");

        buttons[0][0] = button1;
        buttons[0][1] = button2;
        buttons[1][0] = button3;
        buttons[1][1] = button4;
        //buttons[2][0] = button5;

        return buttons;
    }

    private ReplyKeyboardMarkup getMainKeyboard() {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        KeyboardButton button1 = new KeyboardButton("Отримати інфо");
        KeyboardButton button2 = new KeyboardButton("Налаштування");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);

        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setOneTimeKeyboard(false);
        replyMarkup.setKeyboard(keyboard);

        return replyMarkup;
    }

    private void handleDecimalPlacesSetting(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setOneTimeKeyboard(false);
        replyMarkup.setKeyboard(getDecimalPlacesButtons());

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Оберіть кількість знаків після коми");
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private List<KeyboardRow> getDecimalPlacesButtons() {
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

    private void handleBankSetting(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setOneTimeKeyboard(false);
        replyMarkup.setKeyboard(getBankButtons());

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Оберіть банк");
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private List<KeyboardRow> getBankButtons() {
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
    private void handleCurrenciesSetting(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setOneTimeKeyboard(false);
        replyMarkup.setKeyboard(getCurrenciesButtons());

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Оберіть валюти");
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private List<KeyboardRow> getCurrenciesButtons() {
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

    private void handleNotificationTimeSetting(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setOneTimeKeyboard(false);
        replyMarkup.setKeyboard(getNotificationTimeButtons());

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Оберіть час оповіщень");
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private List<KeyboardRow> getNotificationTimeButtons() {
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


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
