import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatHistory {

    private static final String FILE_NAME = "chat_history.txt";

    // 📥 Load messages
    public static List<String> loadMessages() {

        List<String> history = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return history;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                history.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error loading history: " + e.getMessage());
        }

        return history;
    }

    // 💾 Save message
    public static void saveMessage(String message) {

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(message + "\n");

        } catch (IOException e) {
            System.out.println("Error saving history: " + e.getMessage());
        }
    }

    // 🧹 Clear history
    public static void clearHistory() {

        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write("");

        } catch (IOException e) {
            System.out.println("Error clearing history: " + e.getMessage());
        }
    }
}