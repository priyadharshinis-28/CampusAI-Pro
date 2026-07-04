import java.util.ArrayList;
import java.util.List;

public class AchievementManager {

    private static final List<String> achievements = new ArrayList<>();

    static {
        achievements.add("🎉 Welcome to CampusAI Pro");
    }

    public static void unlock(String achievement) {

        if (!achievements.contains(achievement)) {
            achievements.add(achievement);
        }
    }

    public static List<String> getAchievements() {
        return achievements;
    }

    public static void checkAchievements() {

        if (ProductivityTracker.getQuestionsAsked() >= 1)
            unlock("💬 First Question Asked");

        if (ProductivityTracker.getQuestionsAsked() >= 10)
            unlock("🔥 Curious Learner");

        if (ProductivityTracker.getPlannerTasks() >= 5)
            unlock("📚 Study Planner Champion");

        if (ProductivityTracker.getInterviewQuestions() >= 5)
            unlock("🎤 Interview Explorer");

        if (ProductivityTracker.getProductivityScore() >= 80)
            unlock("🏆 Productivity Master");
    }
}