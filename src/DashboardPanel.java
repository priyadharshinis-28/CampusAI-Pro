import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashboardPanel extends JPanel {

    private JLabel totalTasksLabel;
    private JLabel completedTasksLabel;
    private JLabel notesLabel;
    private JLabel gpaLabel;
    private JLabel jlptLabel;
    private JLabel progressLabel;

    public DashboardPanel() {

        setLayout(new BorderLayout());
        setBackground(Colors.BACKGROUND);
        setBorder(new EmptyBorder(25,25,25,25));

        JLabel heading = new JLabel("CampusAI Live Dashboard");
        heading.setFont(Theme.TITLE_FONT);
        heading.setForeground(Colors.TEXT_PRIMARY);

        add(heading, BorderLayout.NORTH);

        JPanel cards = new JPanel(new GridLayout(2,3,20,20));
        cards.setOpaque(false);

        totalTasksLabel = createCard("📚 Total Study Tasks", "0");
        completedTasksLabel = createCard("✅ Completed Tasks", "0");
        notesLabel = createCard("📝 Notes Saved", "0");
        gpaLabel = createCard("🎓 Current GPA", "0.00");
        jlptLabel = createCard("🇯🇵 JLPT Level", "N5");
        progressLabel = createCard("📈 JLPT Progress", "0%");

        cards.add((JPanel) totalTasksLabel.getParent());
        cards.add((JPanel) completedTasksLabel.getParent());
        cards.add((JPanel) notesLabel.getParent());
        cards.add((JPanel) gpaLabel.getParent());
        cards.add((JPanel) jlptLabel.getParent());
        cards.add((JPanel) progressLabel.getParent());

        add(cards, BorderLayout.CENTER);

        refreshDashboard();
    }

    private JLabel createCard(String title, String value) {

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Colors.CARD);
        card.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(Theme.SUB_HEADER_FONT);
        titleLabel.setForeground(Colors.TEXT_PRIMARY);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        valueLabel.setForeground(Colors.ACCENT);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return valueLabel;
    }

    public void refreshDashboard() {

        totalTasksLabel.setText(
                String.valueOf(DashboardData.getTotalTasks()));

        completedTasksLabel.setText(
                String.valueOf(DashboardData.getCompletedTasks()));

        notesLabel.setText(
                String.valueOf(DashboardData.getNotesCount()));

        gpaLabel.setText(
                String.format("%.2f", DashboardData.getCurrentGPA()));

        jlptLabel.setText(
                DashboardData.getJlptLevel());

        progressLabel.setText(
                DashboardData.getJlptProgress() + "%");
    }
}