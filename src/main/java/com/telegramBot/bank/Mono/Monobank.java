package com.telegramBot.bank.Mono;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.telegramBot.bank.CurrencyEnum;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Monobank {

    public static String urlMono = "https://api.monobank.ua/bank/currency";
    public static int desiredCode;// Для перетворення валюти в код цієї валюти
    public static String desimalCode;//Формат округлення
    public static String resultMono="";//Остаточний результат
    public  static BigDecimal buy;//Покупка валюти
    public static BigDecimal sell;//Продаж валюти


    public static String getCurrencySell(CurrencyEnum [] currency, int number) {

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
        
        // + Ira.Y
        resultMono = ""; // Очищення resultMono перед початком нової ітерації
        // - Ira.Y

        for (CurrencyEnum cur : currency) {

            switch (cur) {
                case USD -> desiredCode = 840;
                case EUR -> desiredCode = 978;
                default -> desiredCode = 980;
            }

            for (CurrencyRateMonoResponceDTO it : items) {
                if (it.getCurrencyCodeA() == desiredCode && it.getCurrencyCodeB() == 980) {
                    filteredObjects.add(it);
                }
            }

            //Выводим найденные объекты
            for (CurrencyRateMonoResponceDTO it : filteredObjects) {
                buy = it.getRateBuy();
                sell = it.getRateSell();
            }

            //Знаки после запятой;

            switch (number) {
                case 2 -> desimalCode = "#.##";
                case 3 -> desimalCode = "#.###";
                case 4 -> desimalCode = "#.####";
                default -> desimalCode = "#.#";
            }
            DecimalFormat decimalFormat = new DecimalFormat(desimalCode);
            String resultForSell = decimalFormat.format(sell);
            String resultForBuy = decimalFormat.format(buy);

            resultMono = resultMono + "\n\nКурс в Монобанк:" + cur + "/UAH\nПокупка: " + resultForSell + "\nПродажа: " + resultForBuy;
            //змінити строку виводу, купівля і продаж

        }
        return resultMono;
    }

    public static void main(String[] args) {
        System.out.println(getCurrencySell(new CurrencyEnum[]{CurrencyEnum.EUR}, 4));
    }

}

