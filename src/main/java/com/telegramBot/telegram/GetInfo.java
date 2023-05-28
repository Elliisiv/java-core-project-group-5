package com.telegramBot.telegram;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
import com.telegramBot.bank.BankEnum;
import com.telegramBot.bank.BankEnumFormatter;
import com.telegramBot.bank.CurrencyEnum;
import com.telegramBot.bank.CurrencyEnumFormatter;
import com.telegramBot.bank.Mono.Monobank;
import com.telegramBot.bank.NBU.NBU;
import com.telegramBot.bank.Privat.GetCurrencyPrivatbank;

import java.io.IOException;
import java.util.ArrayList;

import static org.apache.commons.lang3.ArrayUtils.toArray;
import static org.apache.commons.lang3.ArrayUtils.toStringArray;

public class GetInfo {

    public static String getInfo(long chatId) throws IOException {

        String info = "";
        UserSettings userSettings = new UserSettings();

        User retrievedUser = userSettings.getUserSettingsByChatId(chatId);

        CurrencyEnumFormatter currencyFormatter = new CurrencyEnumFormatter();

        ArrayList<String> cur = new ArrayList<>();
        if (retrievedUser.isUsdCurr()) cur.add("USD");
        if (retrievedUser.isEurCurr()) cur.add("EUR");

        CurrencyEnum [] currency  = new CurrencyEnum[cur.size()];

        for (int i = 0; i < cur.size() ; i++){
            currency[i] = currencyFormatter.getCurrencyEnumValue(cur.get(i));
        }

        if (retrievedUser.isPrivatBank()) {

            info = info + GetCurrencyPrivatbank.GetExchangePrivatbank(currency, retrievedUser.getRounding());

        } else if (retrievedUser.isMonoBank()) {

            info = info +  Monobank.getCurrencySell(currency, retrievedUser.getRounding());

        } else if (retrievedUser.isNbuBank()){
            info = info +  NBU.getCurrencyRate(currency, retrievedUser.getRounding()) ;
        }


        return info ;
    }

}
