package com.telegramBot.bank.Privat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

public class Privatbank {

    private String baseCurrency;
    private String currency;
    private String purchaseRate;
    private String saleRate;


    public void Privatbank(String baseCurrency, String currency, String purchaseRate, String saleRate){
        this.baseCurrency = baseCurrency;
        this.currency = currency;
        this.purchaseRate = purchaseRate;
        this.saleRate = saleRate;

    }

    public String get_base_currency() {
        return baseCurrency;
    }
    public String get_currency() {
        return currency;
    }
    public String get_purchase() {
        return purchaseRate;
    }

}

