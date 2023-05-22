package com.telegramBot.bank.Mono;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.telegramBot.bank.BankEnum;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.telegramBot.bank.BankEnum.*;

public class Monobank {

    public static String urlMono = "https://api.monobank.ua/bank/currency";

    public static BigDecimal buy;
    public static BigDecimal sell;

    public static int desiredCode;// Для перетворення валюти в код цієї валюти

    public static BigDecimal getCurrencySell(BankEnum currency) {

        if (currency == USD) {
            desiredCode = 840;
        } else if (currency == EUR) {
            desiredCode = 978;
        } else if (currency == UAH) {
            desiredCode = 980;
        } else {
            desiredCode = 0;
        }

        String json = null;
        try {
            json = Jsoup.connect(urlMono)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            System.out.println("Can`t get currency");
        }

        Type type = TypeToken.getParameterized(List.class, CurrencyRateMonoResponceDTO.class)
                .getType();

        List<CurrencyRateMonoResponceDTO> items = new Gson().fromJson(json, type);

        List<CurrencyRateMonoResponceDTO> filteredObjects = new ArrayList<>();
        for (CurrencyRateMonoResponceDTO it : items) {
            if (it.getCurrencyCodeA() == desiredCode && it.getCurrencyCodeB()==980) {
                filteredObjects.add(it);
            }
        }

        //Выводим найденные объекты
        for (CurrencyRateMonoResponceDTO it : filteredObjects) {
            //buy = it.getRateBuy();
            sell = it.getRateSell();
        }
        return sell;
    }

    public static BigDecimal getCurrencyBuy (BankEnum currency){

            if (currency == USD) {
                desiredCode = 840;
            } else if (currency == EUR) {
                desiredCode = 978;
            } else if (currency == UAH) {
                desiredCode = 980;
            } else {
                desiredCode = 0;
            }

            String json = null;
            try {
                json = Jsoup.connect(urlMono)
                        .ignoreContentType(true)
                        .get()
                        .body()
                        .text();
            } catch (IOException e) {
                System.out.println("Can`t get currency");
            }

            Type type = TypeToken.getParameterized(List.class, CurrencyRateMonoResponceDTO.class)
                    .getType();

            List<CurrencyRateMonoResponceDTO> items = new Gson().fromJson(json, type);

            return items.stream()
                    .filter(it -> it.getCurrencyCodeA() == desiredCode)
                    .map(it -> it.getRateBuy())
                    .findFirst()
                    .orElseThrow();
        }
}
