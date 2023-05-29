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
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class GetInfo {

    public static String info;

    public static void main(String[] args) throws IOException {
     ///   info = getInfo();
      //  System.out.println(info);
    }

    public static String getInfo(long chatId) throws IOException {

        String info = "";
        UserSettings userSettings = new UserSettings();

        
   //     long chatId = 12111;    // Mono   +
 //         long chatId = 22221;    // Privat  +
//        long chatId = 8888888;  // NBU  +


        User retrievedUser = userSettings.getUserSettingsByChatId(chatId);
        CurrencyEnumFormatter currencyFormatter = new CurrencyEnumFormatter();
        

        CurrencyEnum [] currency = new CurrencyEnum[0];
        
        if(retrievedUser.getUsdCurr() && retrievedUser.getEurCurr()){
            currency  = new CurrencyEnum[2];
            currency [0] = currencyFormatter.getCurrencyEnumValue("USD");  
            currency [1] = currencyFormatter.getCurrencyEnumValue("EUR");
        }

        if(retrievedUser.getUsdCurr()) {
            currency  = new CurrencyEnum[1];
            currency [0] = currencyFormatter.getCurrencyEnumValue("USD");
        }

        if(retrievedUser.getEurCurr()){
            currency  = new CurrencyEnum[1];
            currency [0] = currencyFormatter.getCurrencyEnumValue("EUR");
        }
        
            if (retrievedUser.isPrivatBank()) {

                info = info + GetCurrencyPrivatbank.GetExchangePrivatbank(currency, retrievedUser.getRounding());

            }

            if (retrievedUser.isMonoBank()) {

                info = info +  Monobank.getCurrencySell(currency, retrievedUser.getRounding());

            }

            if (retrievedUser.isNbuBank()){
                info = info +  NBU.getCurrencyRate(currency, retrievedUser.getRounding()) ;
            }

        return info ;
    }

}
