package com.telegramBot.bank.NBU;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.telegramBot.bank.BankService.CurrencyEnum;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.List;


public class NBU {
    public static String desimalCode;//Формат округлення
    private static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    public static String getCurrencyRate(CurrencyEnum [] currency, int number) {

        String resultNBU = "";

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

        for (CurrencyEnum cur : currency) {

            double rez = items.stream()
                    .filter(item -> item.getCc() == cur)
                    .map(item -> item.getRate())
                    .findFirst()
                    .orElseThrow();

            switch (number) {
                case 2 -> desimalCode = "#.##";
                case 3 -> desimalCode = "#.###";
                case 4 -> desimalCode = "#.####";
                default -> desimalCode = "#.#";
            }
            DecimalFormat decimalFormat = new DecimalFormat(desimalCode);
            String result = decimalFormat.format(rez);


            resultNBU = resultNBU + "\n\nНБУ: " + cur + "/UAH\nКурс: " + result;
            //написати шось

        }
         return resultNBU ;
    }
}
