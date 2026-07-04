public class DashboardData {

    // ---------- Study Planner ----------
    private static int totalTasks = 0;
    private static int completedTasks = 0;

    // ---------- Notes ----------
    private static int notesCount = 0;

    // ---------- GPA ----------
    private static double currentGPA = 0.0;

    // ---------- Japan ----------
    private static String jlptLevel = "N5";
    private static int jlptProgress = 0;

    // ================= STUDY =================

    public static int getTotalTasks() {
        return totalTasks;
    }

    public static void setTotalTasks(int totalTasks) {
        DashboardData.totalTasks = totalTasks;
    }

    public static int getCompletedTasks() {
        return completedTasks;
    }

    public static void setCompletedTasks(int completedTasks) {
        DashboardData.completedTasks = completedTasks;
    }

    // ================= NOTES =================

    public static int getNotesCount() {
        return notesCount;
    }

    public static void setNotesCount(int notesCount) {
        DashboardData.notesCount = notesCount;
    }

    // ================= GPA =================

    public static double getCurrentGPA() {
        return currentGPA;
    }

    public static void setCurrentGPA(double currentGPA) {
        DashboardData.currentGPA = currentGPA;
    }

    // ================= JAPAN =================

    public static String getJlptLevel() {
        return jlptLevel;
    }

    public static void setJlptLevel(String jlptLevel) {
        DashboardData.jlptLevel = jlptLevel;
    }

    public static int getJlptProgress() {
        return jlptProgress;
    }

    public static void setJlptProgress(int jlptProgress) {
        DashboardData.jlptProgress = jlptProgress;
    }
}