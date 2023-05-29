package com.telegramBot.telegram.buttons;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;

public class ButtonHandler {
    private UserSettings userSettings;

    public ButtonHandler() {
        this.userSettings = new UserSettings();
    }

    public void handleBankButton(String buttonText, long chatId) {
        User user = userSettings.getUserSettingsByChatId(chatId);

        String[] banks = null;

        if (buttonText.equals("НБУ")) {
            banks = new String[]{"NBU"};
        } else if (buttonText.equals("ПриватБанк")) {
            banks = new String[]{"Privat"};
        } else if (buttonText.equals("Монобанк")) {
            banks = new String[]{"Mono"};
        }

        user.setBanks(banks);
        userSettings.updateUserSettings(user);
    }

    public void handleCurrencyButton(String buttonText, long chatId) {
        User user = userSettings.getUserSettingsByChatId(chatId);

        String[] currencies = null;

        if (buttonText.equals("USD")) {
            currencies = new String[]{"USD"};
        } else if (buttonText.equals("EUR")) {
            currencies = new String[]{"EUR"};
        }

            user.setCurrencies(currencies);
            userSettings.updateUserSettings(user);
        }


    public void handleRoundingButton(String buttonText, long chatId) {
        User user = userSettings.getUserSettingsByChatId(chatId);

        int rounding = 0;

        if (buttonText.equals("2")) {
            rounding = 2;
        } else if (buttonText.equals("3")) {
            rounding = 3;
        } else if (buttonText.equals("4")) {
            rounding =4;
        }
            user.setRounding(rounding);
            userSettings.updateUserSettings(user);
        }

    public void handleTimeButton(String buttonText, long chatId) {
        User user = userSettings.getUserSettingsByChatId(chatId);

        String time = "";

        if (buttonText.equals("9")) {
            time = "9";
        } else if (buttonText.equals("10")) {
            time = "10";
        }else if (buttonText.equals("11")) {
            time = "11";
        }else if (buttonText.equals("12")) {
            time = "12";
        }else if (buttonText.equals("13")) {
            time = "13";
        }else if (buttonText.equals("14")) {
            time = "14";
        }else if (buttonText.equals("15")) {
            time = "15";
        }else if (buttonText.equals("16")) {
            time = "16";
        }else if (buttonText.equals("17")) {
            time = "17";
        }else if (buttonText.equals("18")) {
            time = "18";
        }
            user.setTime(time);
            userSettings.updateUserSettings(user);
        }
    }
