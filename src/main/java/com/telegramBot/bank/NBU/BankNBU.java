package com.telegramBot.bank.NBU;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class BankNBU {
    private static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    public static double getCurrencyRate(NBUdto.Currency currency) {

        String json;
        {
            try {
                json = Jsoup.connect(url)
                        .ignoreContentType(true)
                        .get()
                        .body()
                        .text();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Type type = TypeToken.getParameterized(List.class, NBUdto.class).getType();
        List<NBUdto> items = new Gson().fromJson(json, type);

        return items.stream()
                .filter(item -> item.getCc() == currency)
                .map(item -> item.getRate())
                .findFirst()
                .orElseThrow();
    }
}
