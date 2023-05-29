package com.telegramBot.telegram;

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
                    sendWelcomeMessage(chatId);
                    start(chatId);
                    //sendMainKeyboard(chatId);
                    break;
                case "Отримати інфо":
                    sendInfo(chatId);
                    break;
                case "Налаштування":
                    sendSettingsKeyboard(chatId);
                    break;
                case "Кількість знаків після коми":
                    handleDecimalPlacesSetting(chatId);
                    break;
                case "Банк":
                    handleBankSetting(chatId);
                    break;
                case "Валюти":
                    handleCurrenciesSetting(chatId);
                    break;
                case "Час сповіщень":
                    handleNotificationTimeSetting(chatId);
                    break;
                case "Назад":
                    sendSettingsKeyboard(chatId);
                    break;
                case "Прийняти":
                    sendInfo(chatId);
                    break;
                case "Відхилити":
                    sendMainKeyboard(chatId);
                    break;
            }
        }
    }

    private void sendWelcomeMessage(long chatId) {
        String welcomeMessage = "Ласкаво просимо. Цей бот допоможе відслідковувати актуальні курси валют";
        SendMessage message = createMessage(chatId, welcomeMessage);
        sendMessage(message);
    }

    private void sendInfo(long chatId) {
        String currencyInfo = "Курс валют: ";
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
    
    private void start(long chatId) {
        LocalDateTime start = LocalDateTime.now();

        Thread startBut = new Thread(() -> {
            sendMainKeyboard(chatId);
        });

        Thread startTimer = new Thread(() -> {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            LocalTime currentTime = LocalTime.now();

            UserSettings userSettings = new UserSettings();
            User retrievedUser = userSettings.getUserSettingsByChatId(chatId);
            int timeInt = Integer.parseInt(retrievedUser.getTime());

            LocalTime targetTime = LocalTime.of(timeInt, 06); // Задайте бажаний час

            long initialDelay = ChronoUnit.MILLIS.between(currentTime, targetTime);
            if (initialDelay < 0) {
                // Якщо поточний час вже пройшов бажаний час, додаємо 1 день до initialDelay
                initialDelay += TimeUnit.DAYS.toMillis(1);
            }

            long period = TimeUnit.DAYS.toMillis(1);

            ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
                try {
                    sendInfo(chatId);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, initialDelay, period, TimeUnit.MILLISECONDS);

            // Зупиняємо виконання потока після 24 годин
            executor.schedule(() -> future.cancel(true), period, TimeUnit.MILLISECONDS);
        });

        startBut.start();
        startTimer.start();
    }
}
