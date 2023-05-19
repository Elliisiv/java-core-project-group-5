import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.telegramBot.User.User;

import java.io.FileWriter;
import java.io.IOException;

public class JSONUtils {
    public static void createJsonFile(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);

        try (FileWriter writer = new FileWriter("userSettings.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}