public class ProductivityTracker {

    private static int questionsAsked = 0;
    private static int plannerTasks = 0;
    private static int interviewQuestions = 0;

    public static void questionAsked() {
        questionsAsked++;
    }

    public static void plannerCompleted() {
        plannerTasks++;
    }

    public static void interviewCompleted() {
        interviewQuestions++;
    }

    public static int getQuestionsAsked() {
        return questionsAsked;
    }

    public static int getPlannerTasks() {
        return plannerTasks;
    }

    public static int getInterviewQuestions() {
        return interviewQuestions;
    }

    public static int getProductivityScore() {

        int score = questionsAsked * 2
                + plannerTasks * 10
                + interviewQuestions * 5;

        return Math.min(score, 100);
    }
}