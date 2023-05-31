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
    public static int desiredCode;
    public static String desimalCode;
    public static String resultMono = "";
    public static BigDecimal buy;
    public static BigDecimal sell;
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

        resultMono = "";

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

            for (CurrencyRateMonoResponceDTO it : filteredObjects) {
                buy = it.getRateBuy();
                sell = it.getRateSell();
            }

            switch (number) {
                case 2 -> desimalCode = "#.##";
                case 3 -> desimalCode = "#.###";
                case 4 -> desimalCode = "#.####";
                default -> desimalCode = "#.#";
            }
            DecimalFormat decimalFormat = new DecimalFormat(desimalCode);
            String resultForSell = formatterString(decimalFormat.format(sell), number);
            String resultForBuy = formatterString(decimalFormat.format(buy), number);
            resultMono = resultMono + "\n\nМонобанк:" + cur + "/UAH\nКупівля: " + resultForBuy + "\nПродаж: " + resultForSell;
        }
        return resultMono;
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
        try (FileWriter writer = new FileWriter(settingsFile)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String formatterString(String num, int number){
        String result = "";
        String part2 = "";
        String [] part = num.split(",");
        switch (number - part[1].length()) {
            case 1 -> part2 = part[1] + "0" ;
            case 2 -> part2 = part[1] + "00" ;
            case 3 -> part2 = part[1] + "000" ;
            case 4 -> part2 = part[1] + "0000" ;
            default ->  part2 = part[1];
        }
        result = part[0] + "."  + part2 ;
        return result;
    }
}