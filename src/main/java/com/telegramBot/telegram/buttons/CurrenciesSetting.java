package com.telegramBot.telegram.buttons;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
import com.telegramBot.bank.ConditionCurrencyFormatter;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class CurrenciesSetting {
    public static ReplyKeyboardMarkup getCurrencies(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getCurrenciesButtons(chatId));

        return replyMarkup;
    }

    private static List<KeyboardRow> getCurrenciesButtons(long chatId) {

//        UserSettings userSettings = new UserSettings();
//        User user = userSettings.getUserSettingsByChatId(chatId);
        ConditionCurrencyFormatter conditionCurrencyFormatter = new  ConditionCurrencyFormatter(chatId);

        KeyboardRow row1 = new KeyboardRow();
        if(!conditionCurrencyFormatter.isUsdCurr() && conditionCurrencyFormatter.isEurCurr()) {
            row1.add(new KeyboardButton("USD"));
            row1.add(new KeyboardButton("EUR ✅"));
        }
        if(conditionCurrencyFormatter.isUsdCurr() && !conditionCurrencyFormatter.isEurCurr()) {
            row1.add(new KeyboardButton("USD ✅"));
            row1.add(new KeyboardButton("EUR"));
        }
        if(conditionCurrencyFormatter.isUsdCurr() && conditionCurrencyFormatter.isEurCurr()) {
            row1.add(new KeyboardButton("USD ✅"));
            row1.add(new KeyboardButton("EUR ✅"));
        }

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Назад"));

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(row1);
        keyboardRows.add(row2);

        return keyboardRows;
    }
}
