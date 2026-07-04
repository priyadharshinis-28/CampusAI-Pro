public class ProfileManager {

    private static String name = "Priyadharshini";
    private static String department = "Data Science";
    private static String semester = "III";
    private static String goal = "Japan AI Engineer";

    public static String getName() {
        return name;
    }

    public static String getDepartment() {
        return department;
    }

    public static String getSemester() {
        return semester;
    }

    public static String getGoal() {
        return goal;
    }

    public static void setName(String value) {
        name = value;
    }

    public static void setDepartment(String value) {
        department = value;
    }

    public static void setSemester(String value) {
        semester = value;
    }

    public static void setGoal(String value) {
        goal = value;
    }
}