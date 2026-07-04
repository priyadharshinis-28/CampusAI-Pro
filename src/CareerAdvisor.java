import javax.swing.*;
import java.awt.*;

public class CareerAdvisor extends JPanel {

    private JComboBox<String> interestBox;
    private JComboBox<String> levelBox;
    private JTextField cgpaField;
    private JTextField skillsField;
    private JTextArea resultArea;

    public CareerAdvisor() {

        setLayout(new BorderLayout(15, 15));
        setBackground(Colors.BACKGROUND);

        // ---------------- TITLE ----------------
        JLabel title = new JLabel("💼 Career Advisor");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Colors.TEXT_PRIMARY);
        title.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        add(title, BorderLayout.NORTH);

        // ---------------- INPUT PANEL ----------------
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBackground(Colors.BACKGROUND);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel interestLabel = new JLabel("Interest");
        interestLabel.setForeground(Colors.TEXT_PRIMARY);

        interestBox = new JComboBox<>(new String[]{
                "AI & ML",
                "Data Science",
                "Web Development",
                "Cyber Security",
                "Cloud Computing"
        });

        JLabel levelLabel = new JLabel("Skill Level");
        levelLabel.setForeground(Colors.TEXT_PRIMARY);

        levelBox = new JComboBox<>(new String[]{
                "Beginner",
                "Intermediate",
                "Advanced"
        });

        JLabel cgpaLabel = new JLabel("CGPA");
        cgpaLabel.setForeground(Colors.TEXT_PRIMARY);

        cgpaField = new JTextField();

        JLabel skillsLabel = new JLabel("Programming Skills");
        skillsLabel.setForeground(Colors.TEXT_PRIMARY);

        skillsField = new JTextField();
        skillsField.setToolTipText("Example: Java, Python, SQL");

        JButton recommendButton = new JButton("Recommend Career");

        inputPanel.add(interestLabel);
        inputPanel.add(interestBox);

        inputPanel.add(levelLabel);
        inputPanel.add(levelBox);

        inputPanel.add(cgpaLabel);
        inputPanel.add(cgpaField);

        inputPanel.add(skillsLabel);
        inputPanel.add(skillsField);

        inputPanel.add(new JLabel(""));
        inputPanel.add(recommendButton);

        add(inputPanel, BorderLayout.WEST);

        // ---------------- RESULT AREA ----------------
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(Theme.BODY_FONT);
        resultArea.setBackground(Colors.BACKGROUND);
        resultArea.setForeground(Colors.TEXT_PRIMARY);
        resultArea.setMargin(new Insets(15, 15, 15, 15));

        resultArea.setText("""
Welcome to Career Advisor!

Fill all the fields and click
'Recomment Career'.
""");

        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        recommendButton.addActionListener(e -> showRecommendation());
    }

    private void showRecommendation() {

        try {

            String interest = (String) interestBox.getSelectedItem();
            String level = (String) levelBox.getSelectedItem();

            double cgpa = Double.parseDouble(cgpaField.getText());

            String skills = skillsField.getText().toLowerCase();

            int score = 0;

            // ---------------- CGPA SCORE ----------------
            if (cgpa >= 9.0)
                score += 40;
            else if (cgpa >= 8.0)
                score += 35;
            else if (cgpa >= 7.0)
                score += 30;
            else
                score += 20;

            // ---------------- LEVEL SCORE ----------------
            switch (level) {
                case "Beginner" -> score += 10;
                case "Intermediate" -> score += 20;
                case "Advanced" -> score += 30;
            }

            // ---------------- SKILLS SCORE ----------------
            if (skills.contains("java"))
                score += 10;

            if (skills.contains("python"))
                score += 10;

            if (skills.contains("sql"))
                score += 10;

            String career = "";
            String salary = "";
            String missing = "";
            String roadmap = "";

            switch (interest) {

                case "AI & ML" -> {

                    career = "AI Engineer";
                    salary = "₹8 - ₹18 LPA";
                    missing = "Machine Learning\nGit\nDocker";
                    roadmap = """
1. Learn Python
2. Machine Learning
3. Deep Learning
4. Build AI Projects
5. Internship
""";
                }

                case "Data Science" -> {

                    career = "Data Scientist";
                    salary = "₹7 - ₹15 LPA";
                    missing = "Statistics\nPower BI\nTableau";
                    roadmap = """
1. Python
2. Statistics
3. SQL
4. Data Visualization
5. ML Projects
""";
                }

                case "Web Development" -> {

                    career = "Full Stack Developer";
                    salary = "₹5 - ₹12 LPA";
                    missing = "React\nSpring Boot\nGit";
                    roadmap = """
1. HTML
2. CSS
3. JavaScript
4. Java
5. Spring Boot
""";
                }

                case "Cyber Security" -> {

                    career = "Security Analyst";
                    salary = "₹6 - ₹14 LPA";
                    missing = "Linux\nNetworking\nEthical Hacking";
                    roadmap = """
1. Networking
2. Linux
3. Security
4. Ethical Hacking
5. Certifications
""";
                }

                case "Cloud Computing" -> {

                    career = "Cloud Engineer";
                    salary = "₹8 - ₹16 LPA";
                    missing = "AWS\nDocker\nKubernetes";
                    roadmap = """
1. Linux
2. Cloud Basics
3. AWS
4. Docker
5. Kubernetes
""";
                }
            }

            resultArea.setText(
                    "==============================\n" +
                    "CAREER READINESS REPORT\n" +
                    "==============================\n\n" +

                    "Career Readiness Score : " + score + " / 100\n\n" +

                    "Recommended Career\n" +
                    "⭐ " + career + "\n\n" +

                    "Expected Salary\n" +
                    salary + "\n\n" +

                    "Your Skills\n" +
                    skillsField.getText() + "\n\n" +

                    "Missing Skills\n" +
                    missing + "\n\n" +

                    "Learning Roadmap\n" +
                    roadmap
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid CGPA.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}