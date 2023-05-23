package com.telegramBot;

import com.telegramBot.bank.BankEnum;
import com.telegramBot.bank.Mono.Monobank;
import com.telegramBot.bank.NBU.NBU;
import com.telegramBot.bank.Privat.PrivatBank;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        System.out.println(NBU.getCurrencyRate(BankEnum.USD));

        //System.out.println(Monobank.getCurrencySell(BankEnum.USD));

        System.out.println(PrivatBank.GetExchangePrivateBank(BankEnum.EUR).get_purchase());
        System.out.println(PrivatBank.GetExchangePrivateBank(BankEnum.EUR).get_saleRate());
        System.out.println(PrivatBank.GetExchangePrivateBank(BankEnum.USD).get_purchase());
        System.out.println(PrivatBank.GetExchangePrivateBank(BankEnum.USD).get_saleRate());
    }
}