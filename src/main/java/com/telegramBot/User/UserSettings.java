package com.telegramBot.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserSettings {
    private final String settingsFile = "./files/userSettings.json";


    public void createUserSettings(User user) {
        try {
            List<User> users = getUsers();
            int index = getUserIndexByChatId(users, user.getChatId());
            if (index != -1) {
                users.set(index, user);
            } else {
                users.add(user);
            }
            saveUserSettings(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUserSettingsByChatId(long chatId) {
        try {
            List<User> users = getUsers();
            for (User user : users) {
                if (user.getChatId() == chatId) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<User> getUsers() throws IOException {
        List<User> users = new ArrayList<>();
        File storageFile = new File(settingsFile);
        if (storageFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(storageFile));
            users = new ArrayList<>(Arrays.asList(new Gson().fromJson(reader, User[].class)));
            reader.close();
        }
        return users != null ? users : new ArrayList<>();
    }

    private void saveUserSettings(List<User> users) throws IOException {
        FileWriter writer = new FileWriter(settingsFile);
        new Gson().toJson(users, writer);
        writer.close();
    }

    private int getUserIndexByChatId(List<User> users, long chatId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getChatId() == chatId) {
                return i;
            }
        }
        return -1;
    }
}