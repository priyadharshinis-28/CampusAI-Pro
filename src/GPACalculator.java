import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GPACalculator extends JPanel {

    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> list = new JList<>(listModel);

    private JTextField subjectField = new JTextField();
    private JTextField creditField = new JTextField();
    private JTextField gradeField = new JTextField();

    private JLabel resultLabel = new JLabel("CGPA: 0.0");

    private ArrayList<Double> gradePoints = new ArrayList<>();
    private ArrayList<Integer> credits = new ArrayList<>();

    public GPACalculator() {

        setLayout(new BorderLayout());
        setBackground(Colors.BACKGROUND);

        // TITLE
        JLabel title = new JLabel("📊 GPA Calculator");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Colors.TEXT_PRIMARY);
        add(title, BorderLayout.NORTH);

        // CENTER LIST
        list.setFont(Theme.BODY_FONT);
        add(new JScrollPane(list), BorderLayout.CENTER);

        // INPUT PANEL
        JPanel input = new JPanel(new GridLayout(4, 2, 10, 10));
        input.setBackground(Colors.BACKGROUND);

        input.add(new JLabel("Subject:"));
        input.add(subjectField);

        input.add(new JLabel("Credits:"));
        input.add(creditField);

        input.add(new JLabel("Grade (A/B/C/D/F):"));
        input.add(gradeField);

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        input.add(addBtn);
        input.add(deleteBtn);

        add(input, BorderLayout.SOUTH);

        // RESULT
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(Color.GREEN);
        add(resultLabel, BorderLayout.EAST);

        // ACTIONS
        addBtn.addActionListener(e -> addSubject());
        deleteBtn.addActionListener(e -> deleteSubject());
    }

    private void addSubject() {

        String subject = subjectField.getText();
        int credit = Integer.parseInt(creditField.getText());
        String grade = gradeField.getText().toUpperCase();

        double point = convertGrade(grade);

        credits.add(credit);
        gradePoints.add(point);

        listModel.addElement(subject + " | Credits: " + credit + " | Grade: " + grade);

        updateCGPA();

        subjectField.setText("");
        creditField.setText("");
        gradeField.setText("");
    }

    private void deleteSubject() {

        int index = list.getSelectedIndex();

        if (index != -1) {
            listModel.remove(index);
            credits.remove(index);
            gradePoints.remove(index);
            updateCGPA();
        }
    }

    private void updateCGPA() {

        double totalCredits = 0;
        double totalPoints = 0;

        for (int i = 0; i < credits.size(); i++) {
            totalCredits += credits.get(i);
            totalPoints += credits.get(i) * gradePoints.get(i);
        }

        double cgpa = totalCredits == 0 ? 0 : totalPoints / totalCredits;

        resultLabel.setText("CGPA: " + String.format("%.2f", cgpa));
         DashboardData.setCurrentGPA(cgpa);

    // Refresh Dashboard immediately
        NavigationController.showScreen("Dashboard");
        NavigationController.showScreen("GPA Calculator");
    }

    private double convertGrade(String grade) {

        return switch (grade) {
            case "A" -> 10.0;
            case "B" -> 8.0;
            case "C" -> 6.0;
            case "D" -> 4.0;
            default -> 0.0;
        };
    }
}