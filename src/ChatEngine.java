public class ChatEngine {

    private ChatEngine() {
    }

    public static String getResponse(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "Please type something 😊";
        }

        message = message.toLowerCase();

        String response;

        if (message.contains("hello") || message.contains("hi")) {
            response = "Hello 👋 Welcome to CampusAI Pro.";
        }
        else if (message.contains("java")) {
            response = "Java is an object-oriented programming language used to build desktop, web and enterprise applications.";
        }
        else if (message.contains("python")) {
            response = "Python is widely used in AI, Machine Learning, Data Science and Automation.";
        }
        else if (message.contains("gpa")) {
            response = "Open the GPA Calculator from the sidebar to calculate your GPA.";
        }
        else if (message.contains("study")) {
            response = "Create a study plan and follow it consistently every day.";
        }
        else if (message.contains("career")) {
            response = "Career Advisor can recommend skills and roadmaps based on your interests.";
        }
        else if (message.contains("interview")) {
            response = "Interview Mode will help you practice HR and technical questions.";
        }
        else if (message.contains("japan")) {
            response = "CampusAI Pro will guide you with JLPT preparation and IT career opportunities in Japan.";
        }
        else {
            response = "I'm still learning 😊. A smarter AI engine will be added in the next phase.";
        }

        // ✅ SAFE placement (only runs AFTER response is decided)
        if (classExists("AchievementManager")) {
            AchievementManager.checkAchievements();
        }

        return response;
    }

    // helper to avoid crash if class doesn't exist yet
    private static boolean classExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}