package com.telegramBot.telegram;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CurrencyTelegramBot extends  TelegramLongPollingCommandBot{

    @Override
    public void processNonCommandUpdate(Update update) {

    }

    @Override
    public String getBotUsername() {
        return Constans.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return  Constans.BOT_TOKEN;
    }



}
