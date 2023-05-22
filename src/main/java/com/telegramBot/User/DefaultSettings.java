package com.telegramBot.User;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class DefaultSettings {
    private String defaultBank;
    private String defaultCurrency;
    private int decimalPlaces;
    private String notificationTime;

    public DefaultSettings(String defaultBank, String defaultCurrency, int decimalPlaces, String notificationTime) {
        this.defaultBank = defaultBank;
        this.defaultCurrency = defaultCurrency;
        this.decimalPlaces = decimalPlaces;
        this.notificationTime = notificationTime;
    }

    public void saveDefaultSettingsToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String settingsJson = gson.toJson(this);

        try (FileWriter writer = new FileWriter("./files/defaultSettings.json")) {
            writer.write(settingsJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DefaultSettings loadDefaultSettingsFromFile() {
        try (FileReader reader = new FileReader("./files/defaultSettings.json")) {
            Gson gson = new Gson();
            return gson.fromJson(reader, DefaultSettings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DefaultSettings defaultSettings = new DefaultSettings("Privatbank", "USD", 2, "10.00");
        defaultSettings.saveDefaultSettingsToFile();
        System.out.printf(String.valueOf(loadDefaultSettingsFromFile()));
    }
}