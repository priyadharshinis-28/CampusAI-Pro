import java.util.HashMap;

import java.util.Map;

public class KnowledgeBase {

    private static final Map<String, String> responses = new HashMap<>();

    static {

        // 👋 GREETING
        responses.put("GREETING",
                "👋 Hello " + ProfileManager.getName() +
                "! I’m CampusAI Pro.\nHow can I help you today?");

        // 💻 PROGRAMMING
        responses.put("PROGRAMMING",
                "💡 Programming is a skill built by practice.\n" +
                "Focus on DSA, projects, and consistency rather than memorizing syntax.");

        // 📚 ACADEMIC
        responses.put("ACADEMIC",
                "📚 Study tip:\n" +
                "Use Pomodoro technique + active recall + revision cycles for better retention.");

        // 💼 CAREER
        responses.put("CAREER",
                "💼 Career Growth Tip:\n" +
                "Build 2–3 strong projects + GitHub + internships.\n" +
                "That matters more than certificates alone.");

        // 🎤 INTERVIEW
        responses.put("INTERVIEW",
                "🎤 Interview Prep:\n" +
                "1. HR questions\n2. DSA basics\n3. Projects explanation\n4. Communication skills");

        // 🇯🇵 JAPAN
        responses.put("JAPAN",
                "🇯🇵 Japan Career Path:\n" +
                "Focus on JLPT (N3/N2) + Java + communication skills + internship experience.");

        // 📊 GPA
        responses.put("GPA",
                "📊 GPA Tip:\n" +
                "Maintain consistency across subjects. Even small improvements increase CGPA significantly.");

        // ❓ UNKNOWN
        responses.put("UNKNOWN",
                "🤖 I'm still learning.\nTry asking about:\n" +
                "- Study plan\n- Career\n- GPA\n- Interview\n- Programming\n- Japan jobs");
    }

    public static String getResponse(String intent) {

        if (intent == null) return responses.get("UNKNOWN");

        return responses.getOrDefault(intent, responses.get("UNKNOWN"));
    }
}