package com.telegramBot.bank.Privat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.telegramBot.bank.BankService.CurrencyEnum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;
public class GetCurrencyPrivatbank {
    public static String desimalCode;
    public static BigDecimal buy;
    public static BigDecimal sell;
    public static void main(String[] args) throws IOException {
        String result = GetExchangePrivatbank(new CurrencyEnum[]{CurrencyEnum.USD}, 4);
        System.out.println(result);
    }
    public static String GetExchangePrivatbank(CurrencyEnum[] currency, int number) throws IOException {
        String resultPrivate = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String URL_get_currency = "https://api.privatbank.ua/p24api/exchange_rates?json&date=" + dateFormat.format(new Date());
        Privatbank result = new Privatbank();
        URL url = new URL(URL_get_currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        int responseCode = connection.getResponseCode();
        System.out.println("GET response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson gsonR = new GsonBuilder().setPrettyPrinting().create();
            JsonObject jsonObject = gsonR.fromJson(response.toString(), JsonObject.class);
            JsonArray exchangeRateArray = jsonObject.getAsJsonArray("exchangeRate");
            Privatbank[] currencyList = gsonR.fromJson(exchangeRateArray, Privatbank[].class);
            for (CurrencyEnum cur : currency) {
                for (Privatbank currencyNeeded : currencyList) {
                    if (cur.equals(currencyNeeded.get_currency())) {
                        result = currencyNeeded;
                    }
                }
                buy = result.get_saleRate();
                sell = result.get_purchase();
                switch (number) {
                    case 2 -> desimalCode = "#.##";
                    case 3 -> desimalCode = "#.###";
                    case 4 -> desimalCode = "#.####";
                    default -> desimalCode = "#.#";
                }
                DecimalFormat decimalFormat = new DecimalFormat(desimalCode);
                String resultForSell = formatterString(decimalFormat.format(sell), number);
                String resultForBuy = formatterString(decimalFormat.format(buy), number);
                resultPrivate = resultPrivate + "\n\nПриватБанк: " + cur + "/UAH\nКупівля: " +resultForBuy   + "\nПродаж: " + resultForSell;
            }
        } else {
            System.out.println("GetExchangePrivateBank request not worked");
        }
        return resultPrivate;
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