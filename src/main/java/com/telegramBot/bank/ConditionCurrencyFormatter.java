package com.telegramBot.bank;

import com.telegramBot.User.User;
import com.telegramBot.User.UserSettings;

public class ConditionCurrencyFormatter {

    private boolean UsdCurr = false;
    private boolean EurCurr = false;

    public ConditionCurrencyFormatter(long chatId){

        UserSettings userSettings = new UserSettings();
        User user = userSettings.getUserSettingsByChatId(chatId);

        String [] currencies = user.getCurrencies();

        for (String currency: currencies ){

            if (currency.equals("USD")){
                this.UsdCurr = true;
            }
            if (currency.equals("EUR")){
                this.EurCurr = true;
            }


        }

    }

    public boolean isUsdCurr() {
        return UsdCurr;
    }

    public boolean isEurCurr() {
        return EurCurr;
    }



}
