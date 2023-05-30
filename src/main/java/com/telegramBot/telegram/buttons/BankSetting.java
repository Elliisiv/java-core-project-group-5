
package com.telegramBot.telegram.buttons;

import com.telegramBot.bank.BankService.ConditionBankFormatter;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class BankSetting {
    public static ReplyKeyboardMarkup getBank(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        replyMarkup.setResizeKeyboard(true);
        replyMarkup.setSelective(true);
        replyMarkup.setKeyboard(getBankButtons(chatId));

        return replyMarkup;
    }

    private static List<KeyboardRow> getBankButtons(long chatId) {

        ConditionBankFormatter conditionBankFormatter = new ConditionBankFormatter(chatId);
//        UserSettings userSettings = new UserSettings();
//        User user = userSettings.getUserSettingsByChatId(chatId);
        String emoji_check_mark = EmojiParser.parseToUnicode(":white_check_mark:");
        KeyboardRow row1 = new KeyboardRow();
//        row1.add(new KeyboardButton("ПриватБанк"));
//        row1.add(new KeyboardButton("Монобанк"));
//        row1.add(new KeyboardButton("НБУ"));
    //    row1.add(new KeyboardButton("НБУ" + emoji_check_mark));

        if(!conditionBankFormatter.isPrivatBank()&&!conditionBankFormatter.isMonoBank()&&conditionBankFormatter.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(!conditionBankFormatter.isPrivatBank()&&conditionBankFormatter.isMonoBank()&&!conditionBankFormatter.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(!conditionBankFormatter.isPrivatBank()&&conditionBankFormatter.isMonoBank()&&conditionBankFormatter.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(conditionBankFormatter.isPrivatBank()&&!conditionBankFormatter.isMonoBank()&&!conditionBankFormatter.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(conditionBankFormatter.isPrivatBank()&&!conditionBankFormatter.isMonoBank()&&conditionBankFormatter.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(conditionBankFormatter.isPrivatBank()&&conditionBankFormatter.isMonoBank()&&!conditionBankFormatter.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ"));
        }
        if(conditionBankFormatter.isPrivatBank()&&conditionBankFormatter.isMonoBank()&&conditionBankFormatter.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк ✅"));
            row1.add(new KeyboardButton("Монобанк ✅"));
            row1.add(new KeyboardButton("НБУ ✅"));
        }
        if(conditionBankFormatter.isPrivatBank()&&conditionBankFormatter.isMonoBank()&&conditionBankFormatter.isNbuBank()) {
            row1.add(new KeyboardButton("ПриватБанк"));
            row1.add(new KeyboardButton("Монобанк"));
            row1.add(new KeyboardButton("НБУ"));
        }

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Назад"));

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(row1);
        keyboardRows.add(row2);

        return keyboardRows;
    }
}
