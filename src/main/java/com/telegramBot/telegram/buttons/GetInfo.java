package com.telegramBot.telegram.buttons;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;

import com.telegramBot.bank.BankService.BankEnum;
import com.telegramBot.bank.BankService.BankEnumFormatter;
import com.telegramBot.bank.BankService.CurrencyEnum;
import com.telegramBot.bank.BankService.CurrencyEnumFormatter;

import com.telegramBot.bank.Mono.Monobank;
import com.telegramBot.bank.NBU.NBU;
import com.telegramBot.bank.Privat.GetCurrencyPrivatbank;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class GetInfo {

    public static String info;
    
    public static String getInfo(long chatId) throws IOException {

        String info = "";
        UserSettings userSettings = new UserSettings();
        
        User retrievedUser = userSettings.getUserSettingsByChatId(chatId);

        CurrencyEnumFormatter currencyFormatter = new CurrencyEnumFormatter();

        String [] cur = retrievedUser.getCurrencies();
        CurrencyEnum [] currency  = new CurrencyEnum[cur.length];

        for (int i = 0; i < cur.length ; i++){
            currency[i] = currencyFormatter.getCurrencyEnumValue(cur[i]);
        }

        String [] banks = retrievedUser.getBanks();

        for (String bank: banks) {
            if (bank.equals("Privat")) {

                info = info + GetCurrencyPrivatbank.GetExchangePrivatbank(currency, retrievedUser.getRounding());
                if (info.isEmpty()){
                    info = "Оберіть валюту в налаштуваннях";
                }

            } else if (bank.equals("Mono")) {

                info = info +  Monobank.getCurrencySell(currency, retrievedUser.getRounding());
                if (info.isEmpty()){
                    info = "Оберіть валюту в налаштуваннях";
                }

            } else if (bank.equals("NBU")){
                info = info +  NBU.getCurrencyRate(currency, retrievedUser.getRounding()) ;
                if (info.isEmpty()){
                    info = "Оберіть валюту в налаштуваннях";
                }
            }
        }

        if (info.isEmpty()){
            info = "Оберіть банк в налаштуваннях";
        }

        return info ;
    }

}

