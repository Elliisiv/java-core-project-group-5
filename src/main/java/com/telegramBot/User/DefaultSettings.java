package com.telegramBot.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Data
public class DefaultSettings {
    private String bank;
    private String defaultCurrency;
    private int decimalPlaces;
    private String notificationTime;

    public DefaultSettings(String bank, String defaultCurrency, int decimalPlaces, String notificationTime) {
        this.bank = bank;
        this.defaultCurrency = defaultCurrency;
        this.decimalPlaces = decimalPlaces;
        this.notificationTime = notificationTime;
    }


    public void saveDefaultSettingsToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String settingsJson = gson.toJson(this);

        try (FileWriter writer = new FileWriter("defaultSettings.json")) {
            writer.write(settingsJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DefaultSettings loadDefaultSettingsFromFile() {
        try (FileReader reader = new FileReader("defaultSettings.json")) {
            Gson gson = new Gson();
            return gson.fromJson(reader, DefaultSettings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
//    public static String loadDefaultSettingsFromFile() {
//        try (FileReader reader = new FileReader("defaultSettings.json")) {
//            Gson gson = new Gson();
//            return String.valueOf(gson.fromJson(reader, DefaultSettings.class));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static void main(String[] args) {
        DefaultSettings defaultSettings= new DefaultSettings("PrivatBank", "EUR",2,"10.00" );
        defaultSettings.saveDefaultSettingsToFile();
     //   System.out.printf(loadDefaultSettingsFromFile());
    }
}

