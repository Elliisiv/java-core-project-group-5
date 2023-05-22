package com.telegramBot.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {
    private final String username;
    private final String token;

    public TelegramBot(String username, String tokenKey) {

        this.username = username;
        this.token = tokenKey;
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();

            if (messageText.equals("/start")) {
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText("Ласкаво просимо. Цей бот допоможе відслідковувати актуальні курси валют");

                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                keyboardMarkup.setResizeKeyboard(true);

                KeyboardButton button1 = new KeyboardButton();
                button1.setText("Отримати інфо");

                KeyboardButton button2 = new KeyboardButton();
                button2.setText("Налаштування");

                KeyboardRow row1 = new KeyboardRow();
                row1.add(button1);
                row1.add(button2);

                List<KeyboardRow> keyboard = new ArrayList<>();
                keyboard.add(row1);

                keyboardMarkup.setKeyboard(keyboard);

                message.setReplyMarkup(keyboardMarkup);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
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


//залити