package com.telegramBot.telegram.buttons;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
import com.vdurmont.emoji.EmojiParser;

public class ButtonHandler {
    private UserSettings userSettings;

    public ButtonHandler() {
        this.userSettings = new UserSettings();
    }


    public void handleBankButton(String buttonText, long chatId) {
        User user = userSettings.getUserSettingsByChatId(chatId);

        String[] banks = user.getBanks();
        String emoji_check_mark = EmojiParser.parseToUnicode(":white_check_mark:");

        if (buttonText.equals("НБУ")) { //|| (buttonText.equals("НБУ" + emoji_check_mark))
            if (isBankPresent(banks, "NBU")) {
                banks = removeBank(banks, "NBU");
            } else {
                banks = addBank(banks, "NBU");
            }
        } else if (buttonText.equals("ПриватБанк")) {
            if (isBankPresent(banks, "Privat")) {
                banks = removeBank(banks,"Privat");
            } else {
                banks = addBank(banks, "Privat");
            }
        } else if (buttonText.equals("Монобанк")) {
            if (isBankPresent(banks, "Mono")) {
                banks = removeBank(banks,"Mono");
            } else {
                banks = addBank(banks, "Mono");
            }
        }

        user.setBanks(banks);
        userSettings.updateUserSettings(chatId, user.getBanks(), user.getCurrencies(), user.getRounding(), user.getTime());
    }

    private String[] addBank(String[] banks, String newBank) {
        String[] updatedBanks = new String[banks.length + 1];
        System.arraycopy(banks, 0, updatedBanks, 0, banks.length);
        updatedBanks[banks.length] = newBank;
        return updatedBanks;
    }
    private String[] removeBank(String[] banks, String bankToRemove) {
        String[] updatedBanks = new String[banks.length - 1];
        int index = 0;

        for (String bank : banks) {
            if (!bank.equals(bankToRemove)) {
                updatedBanks[index] = bank;
                index++;
            }
        }

        return updatedBanks;
    }
    private boolean isBankPresent(String[] banks, String bank) {
        if (banks == null) {
            return false;
        }

        for (String b : banks) {
            if (b.equals(bank)) {
                return true;
            }
        }

        return false;
    }

    public void handleCurrencyButton(String buttonText, long chatId) {
        User user = userSettings.getUserSettingsByChatId(chatId);
        String[] currencies = user.getCurrencies();

//         if (buttonText.contains("USD")) {
//             if (isCurrencyPresent(currencies, "USD")) {
//                 currencies = removeCurrency(currencies, "USD");
//             } else {
//                 currencies = addCurrency(currencies, "USD");
//             }
//         } else if (buttonText.contains("EUR")) {
//             if (isCurrencyPresent(currencies, "EUR")) {
//                 currencies = removeCurrency(currencies, "EUR");
//             } else {
//                 currencies = addCurrency(currencies, "EUR");
//             }
//         }
        
        if (buttonText.equals("USD")) {
            currencies = addCurrency(currencies, "USD");
        }

        if (buttonText.equals("USD ✅"))  {
                currencies = removeCurrency(currencies, "USD");
        }
        
        if (buttonText.equals("EUR")) {
                currencies = addCurrency(currencies, "EUR");
        }
        
        if (buttonText.equals("EUR ✅")) {
            currencies = removeCurrency(currencies, "EUR");
        }

        user.setCurrencies(currencies);
        userSettings.updateUserSettings(chatId, user.getBanks(), user.getCurrencies(), user.getRounding(), user.getTime());
    }

    private String[] addCurrency(String[] currencies, String newCurrency) {
        String[] updatedCurrencies = new String[currencies.length + 1];
        System.arraycopy(currencies, 0, updatedCurrencies, 0, currencies.length);
        updatedCurrencies[currencies.length] = newCurrency;
        return updatedCurrencies;
    }

    private String[] removeCurrency(String[] currencies, String currencyToRemove) {
        String[] updatedCurrencies = new String[currencies.length - 1];
        int index = 0;

        for (String currency : currencies) {
            if (!currency.equals(currencyToRemove)) {
                updatedCurrencies[index] = currency;
                index++;
            }
        }

        return updatedCurrencies;
    }

    private boolean isCurrencyPresent(String[] currencies, String currency) {
        if (currencies == null) {
            return false;
        }

        for (String c : currencies) {
            if (c.equals(currency)) {
                return true;
            }
        }

        return false;
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
