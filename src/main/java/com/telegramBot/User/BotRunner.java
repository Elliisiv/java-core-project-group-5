package com.telegramBot.User;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotRunner extends TelegramLongPollingBot {

    private UserSettings userSettings;

    public BotRunner() {
        this.userSettings = new UserSettings();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            System.out.println("Chat ID: " + chatId);

        }
    }

    @Override
    public String getBotUsername() {
        return "Group5CurrencyBot";
    }

    @Override
    public String getBotToken() {
        return "6154656477:AAEPlQcmgRWF_f3qYjQnTnnOmGCxHtmdyKA";
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            BotRunner bot = new BotRunner();
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}