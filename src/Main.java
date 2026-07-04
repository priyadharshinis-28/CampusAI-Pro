import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new LoginPanel().setVisible(true);

        });
    }

    // Opens CampusAI after successful login
    public static void openCampusAI() {

        // REGISTER ALL SCREENS
        NavigationController.addScreen("Dashboard", new DashboardPanel());
        NavigationController.addScreen("Chat", new ChatWindow());
        NavigationController.addScreen("Study Planner", new StudyPlanner());
        NavigationController.addScreen("GPA Calculator", new GPACalculator());
        NavigationController.addScreen("Career Advisor", new CareerAdvisor());
        NavigationController.addScreen("Interview Practice", new InterviewMode());
        NavigationController.addScreen("Analytics", new AnalyticsPanel());
        NavigationController.addScreen("Notes", new NotesManager());
        NavigationController.addScreen("Japan Mode", new JapanMode());
        NavigationController.addScreen("Voice Assistant", new VoiceAssistant());
        NavigationController.addScreen("Settings", new SettingsPanel());

        JFrame frame = new JFrame("CampusAI Pro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setLayout(new BorderLayout());

        frame.add(new HeaderPanel(), BorderLayout.NORTH);
        frame.add(new SidebarPanel(), BorderLayout.WEST);
        frame.add(NavigationController.getMainPanel(), BorderLayout.CENTER);

        NavigationController.showScreen("Dashboard");

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}