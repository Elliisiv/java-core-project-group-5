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

public class GetInfo {

    public static String info;

    public static void main(String[] args) throws IOException {
        info = getInfo();
        System.out.println(info);
    }

    public static String getInfo() throws IOException {

        String info = "";
        UserSettings userSettings = new UserSettings();

        long chatId = 12111;    // Mono   +
 //         long chatId = 22221;    // Privat  +
//        long chatId = 8888888;  // NBU  +

        User retrievedUser = userSettings.getUserSettingsByChatId(chatId);

        CurrencyEnumFormatter currencyFormatter = new CurrencyEnumFormatter();

        String [] cur = retrievedUser.getCurrencies();
        CurrencyEnum [] currency  = new CurrencyEnum[cur.length];

        for (int i = 0; i < cur.length ; i++){
            currency[i] = currencyFormatter.getCurrencyEnumValue(cur[i]);
        }

        BankEnum [] banks = retrievedUser.getBanks();

        for (BankEnum bank: banks) {
            if (bank == BankEnum.PRIVAT) {

                info = info + GetCurrencyPrivatbank.GetExchangePrivatbank(currency, retrievedUser.getRounding());

            } else if (bank == BankEnum.MONO) {

                info = info +  Monobank.getCurrencySell(currency, retrievedUser.getRounding());

            } else if (bank == BankEnum.NBU){
                info = info +  NBU.getCurrencyRate(currency, retrievedUser.getRounding()) ;
            }
        }

        return info ;
    }

}
