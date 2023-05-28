//package com.telegramBot.User;
//
//public class UserSettingsTest {
//    public static void main(String[] args) {
//        //новий  користувач
//        UserSettings userSettings = new UserSettings();
//
//        // Створення і збереження налаштувань
//        User user1 = new User(12111,  new String[]{"Privat", "Mono"}, new String[]{"USD", "EUR"}, 2, "17:00");
//        userSettings.createUserSettings(user1);
//
//        // Отримання налаштувань по chatId
//        long chatId = 12111;
//        User retrievedUser = userSettings.getUserSettingsByChatId(chatId);
//        System.out.println("User settings:" + retrievedUser);
//
//        User user2 = new User(8888888,new String[]{"NBU", "Mono"}, new String[]{"UAH"}, 1, "09:00");
//        userSettings.createUserSettings(user2);
//
//        chatId = 8888888;
//        retrievedUser = userSettings.getUserSettingsByChatId(chatId);
//        System.out.println("User settings:" +retrievedUser);
//
//    }
//}
