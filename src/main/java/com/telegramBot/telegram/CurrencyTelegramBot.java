package com.telegramBot.telegram;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
import com.telegramBot.telegram.buttons.MainKeyboard;
import com.telegramBot.telegram.buttons.SettingsKeyboard;
import com.telegramBot.telegram.buttons.DecimalPlaces;
import com.telegramBot.telegram.buttons.BankSetting;
import com.telegramBot.telegram.buttons.CurrenciesSetting;
import com.telegramBot.telegram.buttons.NotificationTimeSetting;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
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
                case "/start" -> {
                    sendWelcomeMessage(chatId);
                    sendMainKeyboard(chatId);
                }
                case "Отримати інфо" -> {
                    try {
                        sendInfo(chatId);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Налаштування" -> sendSettingsKeyboard(chatId);
                case "Кількість знаків після коми" -> handleDecimalPlacesSetting(chatId);
                case "Банк" -> handleBankSetting(chatId);
                case "Валюти" -> handleCurrenciesSetting(chatId);
                case "Час сповіщень" -> handleNotificationTimeSetting(chatId);
                case "Назад" -> sendSettingsKeyboard(chatId);
                case "Прийняти" -> {
                    try {
                        sendInfo(chatId);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    sendMainKeyboard(chatId);
                }
                case "Відхилити" -> sendMainKeyboard(chatId);
            }
        }
    }

    private void sendWelcomeMessage(long chatId) {
        String welcomeMessage = "Ласкаво просимо. Цей бот допоможе відслідковувати актуальні курси валют";
        SendMessage message = createMessage(chatId, welcomeMessage);
        sendMessage(message);
        //запуск методу для створееня юзера і стандартних налаштувань
        UserSettings userSettings = new UserSettings();
        userSettings.createDefaultSettings(chatId);
    }

    private void sendInfo(long chatId) throws IOException {
//        String currencyInfo = "Курс валют: ";
        String currencyInfo = GetInfo.getInfo(chatId);
        SendMessage message = createMessage(chatId, currencyInfo);
        sendMessage(message);
    }

    private void sendMainKeyboard(long chatId) {
        SendMessage message = createMessage(chatId, "Головне меню");
        message.setReplyMarkup(MainKeyboard.getMainKeyboard());
        sendMessage(message);
    }

    private void sendSettingsKeyboard(long chatId) {
        SendMessage message = createMessage(chatId, "Оберіть налаштування");
        message.setReplyMarkup(SettingsKeyboard.getSettingsKeyboard());
        sendMessage(message);
    }

    private void handleDecimalPlacesSetting(long chatId) {
        SendMessage message = createMessage(chatId, "Оберіть кількість знаків після коми");
        message.setReplyMarkup(DecimalPlaces.getDecimalPlaces());
        sendMessage(message);
    }

    private void handleBankSetting(long chatId) {
        SendMessage message = createMessage(chatId, "Оберіть банк");
        message.setReplyMarkup(BankSetting.getBank(chatId));
        sendMessage(message);
    }

    private void handleCurrenciesSetting(long chatId) {
        SendMessage message = createMessage(chatId, "Оберіть валюти");
        message.setReplyMarkup(CurrenciesSetting.getCurrencies());
        sendMessage(message);
    }

    private void handleNotificationTimeSetting(long chatId) {
        SendMessage message = createMessage(chatId, "Оберіть час сповіщень");
        message.setReplyMarkup(NotificationTimeSetting.getNotificationTime());
        sendMessage(message);
    }

    private SendMessage createMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        return message;
    }

    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    public String getBotToken() {
        return token;
    }
}
