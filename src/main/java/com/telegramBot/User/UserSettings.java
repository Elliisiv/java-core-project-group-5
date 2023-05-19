package com.telegramBot.User;

public class UserSettings {
//    public void updateSettingsFromConsole() {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            System.out.print("Enter bank name: ");
//            String bankName = reader.readLine();
//
//            // Пошук об'єкту банку за назвою
//            Bank selectedBank = findBankByName(bankName);
//
//            System.out.print("Enter currency: ");
//            String currency = reader.readLine();
//
//            System.out.print("Enter decimal places: ");
//            int decimalPlaces = Integer.parseInt(reader.readLine());
//
//            System.out.print("Enter notification time: ");
//            String notificationTime = reader.readLine();
//
//            // Оновлення налаштувань користувача
//            this.bank = selectedBank;
//            this.currency = currency;
//            // Оновлення інших полів
//
//            // Збереження оновлених налаштувань в файлі
//            saveSettingsToFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//public void saveSettingsToFile() {
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    String settingsJson = gson.toJson(this);
//
//    try (FileWriter writer = new FileWriter("userSettings.json", true)) {
//        writer.write(settingsJson);
//        writer.write(System.lineSeparator());
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//
//    public static User loadSettingsFromFile(String chatId) {
//        Gson gson = new Gson();
//        User user = null;
//
//        try (FileReader reader = new FileReader("userSettings.json")) {
//            user = gson.fromJson(reader, User.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return user;
//    }
//
//    // Додаткові методи
}


