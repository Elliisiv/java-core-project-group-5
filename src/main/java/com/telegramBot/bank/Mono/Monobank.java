package com.telegramBot.bank.Mono;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.telegramBot.bank.BankService.CurrencyEnum;
import org.jsoup.Jsoup;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
    public static String resultMono = "";//Остаточний результат
    public static BigDecimal buy;//Покупка валюти
    public static BigDecimal sell;//Продаж валюти
    private static final String settingsFile = "./files/temporaryMono.json";

    public static String getCurrencySell(CurrencyEnum[] currency, int number) {
        String json = null;
        try {
            json = Jsoup.connect(urlMono)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
            changeFile(json);
        } catch (IOException e) {
            System.out.println("Can`t get currency");
            json = readFile();
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
            resultMono = resultMono + "\n\nМонобанк:" + cur + "/UAH\nКупівля: " + resultForBuy + "\nПродаж: " + resultForSell;
        }
        return resultMono;
    }

    public static void main(String[] args) {
        System.out.println(getCurrencySell(new CurrencyEnum[]{CurrencyEnum.EUR}, 4));
    }

    public static String readFile() {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(settingsFile))) {
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the temporaryMono.json file: " + e.getMessage());
        }
        return result;
    }

    public static void changeFile(String json) throws IOException {
        FileWriter writer = new FileWriter(settingsFile);
        writer.flush();
        new Gson().toJson(json, writer);
        writer.close();
    }
}