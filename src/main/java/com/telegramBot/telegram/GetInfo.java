package com.telegramBot.telegram;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;
import com.telegramBot.bank.BankEnum;
import com.telegramBot.bank.BankEnumFormatter;
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

        UserSettings userSettings = new UserSettings();

//        long chatId = 12111;    // Mono   +
        long chatId = 22221;    // Privat  +
//        long chatId = 8888888;  // NBU  +

        User retrievedUser = userSettings.getUserSettingsByChatId(chatId);
//        System.out.println("User settings:" +retrievedUser);

        BankEnumFormatter bankFormatter = new BankEnumFormatter();
        BankEnum bank = bankFormatter.getBankEnumValue(retrievedUser.getCurrencies()[0]);

        if (retrievedUser.getBank().equals("Privat") ){

            //retrievedUser.getCurrencies().length
            info = GetCurrencyPrivatbank.GetExchangePrivatbank(bank , retrievedUser.getRounding());
        } else if (retrievedUser.getBank().equals("Mono")){

            info = Monobank.getCurrencySell( bank , retrievedUser.getRounding());

        } else {


            info = NBU.getCurrencyRate( bank, retrievedUser.getRounding());

        }

        return info ;
    }




}
