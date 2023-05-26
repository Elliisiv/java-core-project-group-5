package com.telegramBot.bank.NBU;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.telegramBot.bank.BankEnum;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.List;


public class NBU {
    public static String desimalCode;//Формат округлення
    private static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    public static String getCurrencyRate(BankEnum currency, int number) {

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

         double rez = items.stream()
                .filter(item -> item.getCc() == currency)
                .map(item -> item.getRate())
                .findFirst()
                .orElseThrow();

            switch (number) {
                case 2 -> desimalCode="#.##";
                case 3 -> desimalCode="#.###";
                case 4 -> desimalCode="#.####";
                default -> desimalCode="#.#";
            }
            DecimalFormat decimalFormat = new DecimalFormat(desimalCode);
            String result = decimalFormat.format(rez);


            String resultNBU = "Курс в НБУ: "+currency+"/UAH\n"+ result ;

         return resultNBU ;
    }
}
