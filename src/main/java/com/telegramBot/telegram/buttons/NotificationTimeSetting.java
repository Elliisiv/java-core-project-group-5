package com.telegramBot.telegram.buttons;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class NotificationTimeSetting {
    public static ReplyKeyboardMarkup getNotificationTime(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getNotificationTimeButtons(chatId));

        return replyMarkup;
    }

    private static List<KeyboardRow> getNotificationTimeButtons(long chatId) {
        UserSettings userSettings = new UserSettings();
        User user = userSettings.getUserSettingsByChatId(chatId);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        KeyboardRow row4 = new KeyboardRow();
        KeyboardRow row5 = new KeyboardRow();

        if(user.getTime().equals("9")) {
            row1.add(new KeyboardButton("9 ✅"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("10")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10 ✅"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("11")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11 ✅"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("12")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12 ✅"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("13")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13 ✅"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("14")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14 ✅"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("15")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15 ✅"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("16")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16 ✅"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("17")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17 ✅"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("18")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18 ✅"));
            row4.add(new KeyboardButton("Вимкнути повідомлення"));
        }
        if(user.getTime().equals("")) {
            row1.add(new KeyboardButton("9"));
            row1.add(new KeyboardButton("10"));
            row1.add(new KeyboardButton("11"));
            row2.add(new KeyboardButton("12"));
            row2.add(new KeyboardButton("13"));
            row2.add(new KeyboardButton("14"));
            row3.add(new KeyboardButton("15"));
            row3.add(new KeyboardButton("16"));
            row3.add(new KeyboardButton("17"));
            row4.add(new KeyboardButton("18"));
            row4.add(new KeyboardButton("Вимкнути повідомлення ✅"));
        }

        row5.add(new KeyboardButton("Назад"));

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboard.add(row5);

        return keyboard;
    }
}
