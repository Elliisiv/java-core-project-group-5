//package com.telegramBot.bank.BankService;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.telegramBot.User.User;
//import com.telegramBot.bank.Mono.Monobank;
//
//public class Parser {       // Витягує налаштування певного користувача
//
//    public static String filePath = "files/userSettings.json";
//
//    public static List<User> readJSONToList(String filePath, long chatID) throws FileNotFoundException {
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//
//
//            Type type = TypeToken.getParameterized(List.class, User.class)
//                    .getType();
//
//            List<User> items = new Gson().fromJson(reader, type);
//
//            List<User> filteredObjects = new ArrayList<>();
//
//            for (User it : items) {
//                if (it.getChatId() == chatID) {
//                    filteredObjects.add(it);
//                }
//            }
//            return filteredObjects;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
////    public static void main(String[] args) throws FileNotFoundException {
////        long chatId = 12111;
////        System.out.println(readJSONToList(filePath, chatId));
////    }
//}