import javax.swing.*;
import java.awt.*;

public class AnalyticsPanel extends JPanel {

    private JLabel studyLabel;
    private JLabel cgpaLabel;
    private JLabel careerLabel;
    private JLabel interviewLabel;
    private JLabel projectLabel;

    private JProgressBar studyBar;
    private JProgressBar careerBar;
    private JProgressBar placementBar;

    public AnalyticsPanel() {

        setLayout(new BorderLayout(20,20));
        setBackground(Colors.BACKGROUND);

        JLabel title = new JLabel("📊 Student Analytics Dashboard");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Colors.TEXT_PRIMARY);
        title.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));

        add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(8,1,15,15));
        center.setBackground(Colors.BACKGROUND);
        center.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));

        studyLabel = new JLabel("📚 Study Planner Completion : 80%");
        cgpaLabel = new JLabel("🎓 Current CGPA : 8.45");
        careerLabel = new JLabel("💼 Career Readiness : 82%");
        interviewLabel = new JLabel("🎤 Interview Score : 76%");
        projectLabel = new JLabel("🚀 Projects Completed : 5");

        JLabel[] labels = {
                studyLabel,
                cgpaLabel,
                careerLabel,
                interviewLabel,
                projectLabel
        };

        for (JLabel label : labels) {
            label.setFont(Theme.BODY_FONT);
            label.setForeground(Colors.TEXT_PRIMARY);
            center.add(label);
        }

        center.add(new JLabel("Study Progress"));

        studyBar = new JProgressBar(0,100);
        studyBar.setValue(80);
        studyBar.setStringPainted(true);
        center.add(studyBar);

        center.add(new JLabel("Career Progress"));

        careerBar = new JProgressBar(0,100);
        careerBar.setValue(82);
        careerBar.setStringPainted(true);
        center.add(careerBar);

        center.add(new JLabel("Placement Readiness"));

        placementBar = new JProgressBar(0,100);
        placementBar.setValue(90);
        placementBar.setStringPainted(true);
        center.add(placementBar);

        add(center, BorderLayout.CENTER);
    }
}