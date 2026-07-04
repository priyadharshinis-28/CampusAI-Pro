import java.util.HashMap;
import java.util.Map;

public class NLPProcessor {

    private static final Map<String, String> intentMap = new HashMap<>();

    static {

        // 👋 Greeting
        intentMap.put("hello", "GREETING");
        intentMap.put("hi", "GREETING");
        intentMap.put("hey", "GREETING");

        // 💻 Programming
        intentMap.put("java", "PROGRAMMING");
        intentMap.put("python", "PROGRAMMING");
        intentMap.put("coding", "PROGRAMMING");

        // 📚 Academic
        intentMap.put("study", "ACADEMIC");
        intentMap.put("exam", "ACADEMIC");
        intentMap.put("notes", "ACADEMIC");

        // 💼 Career
        intentMap.put("career", "CAREER");
        intentMap.put("job", "CAREER");
        intentMap.put("placement", "CAREER");

        // 🎤 Interview
        intentMap.put("interview", "INTERVIEW");
        intentMap.put("hr", "INTERVIEW");

        // 📊 GPA
        intentMap.put("gpa", "GPA");
        intentMap.put("cgpa", "GPA");
        intentMap.put("marks", "GPA");

        // 🇯🇵 Japan
        intentMap.put("japan", "JAPAN");
        intentMap.put("jlpt", "JAPAN");
        intentMap.put("tokyo", "JAPAN");
    }

    public static String detectIntent(String input) {

        if (input == null || input.trim().isEmpty()) {
            return "UNKNOWN";
        }

        input = input.toLowerCase();

        // match keywords
        for (Map.Entry<String, String> entry : intentMap.entrySet()) {

            if (input.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return "UNKNOWN";
    }
}