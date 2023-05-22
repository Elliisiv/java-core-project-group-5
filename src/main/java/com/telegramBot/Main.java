package com.telegramBot;

import com.telegramBot.bank.BankEnum;
import com.telegramBot.bank.Mono.Monobank;
import com.telegramBot.bank.NBU.NBU;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println(NBU.getCurrencyRate(BankEnum.USD));
        System.out.println(Monobank.getCurrencySell(BankEnum.USD));
    }
}