import javax.swing.*;
import java.awt.*;

public class InterviewMode extends JPanel {

    private JComboBox<String> domainBox;
    private JComboBox<String> levelBox;

    private JTextArea questionArea;
    private JTextArea answerArea;
    private JTextArea feedbackArea;

    private int currentQuestion = 0;

    private final String[] aiQuestions = {
            "Explain the difference between Machine Learning and Deep Learning.",
            "What is Supervised Learning?",
            "What is Overfitting?",
            "Why is Python popular in AI?",
            "Explain one AI project you have completed."
    };

    private final String[] dsQuestions = {
            "What is Data Science?",
            "Explain Mean, Median and Mode.",
            "What is Data Cleaning?",
            "Difference between Structured and Unstructured Data?",
            "Explain one Data Science project."
    };

    private final String[] javaQuestions = {
            "What is OOP?",
            "Difference between Class and Object?",
            "Explain Inheritance.",
            "What is Polymorphism?",
            "Difference between Array and ArrayList?"
    };

    public InterviewMode() {

        setLayout(new BorderLayout(15,15));
        setBackground(Colors.BACKGROUND);

        // ---------------- TITLE ----------------

        JLabel title = new JLabel("🎤 Interview Practice");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Colors.TEXT_PRIMARY);
        title.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));

        add(title, BorderLayout.NORTH);

        // ---------------- LEFT PANEL ----------------

        JPanel leftPanel = new JPanel(new GridLayout(5,2,10,10));
        leftPanel.setBackground(Colors.BACKGROUND);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

        leftPanel.add(new JLabel("Domain"));

        domainBox = new JComboBox<>(new String[]{
                "AI & ML",
                "Data Science",
                "Java"
        });

        leftPanel.add(domainBox);

        leftPanel.add(new JLabel("Difficulty"));

        levelBox = new JComboBox<>(new String[]{
                "Beginner",
                "Intermediate",
                "Advanced"
        });

        leftPanel.add(levelBox);

        JButton startButton = new JButton("Start Interview");
        JButton evaluateButton = new JButton("Evaluate Answer");
        JButton nextButton = new JButton("Next Question");

        leftPanel.add(startButton);
        leftPanel.add(evaluateButton);

        leftPanel.add(nextButton);
        leftPanel.add(new JLabel(""));

        add(leftPanel, BorderLayout.WEST);

        // ---------------- QUESTION ----------------

        questionArea = new JTextArea(5,40);
        questionArea.setEditable(false);
        questionArea.setFont(Theme.BODY_FONT);
        questionArea.setBackground(Colors.BACKGROUND);
        questionArea.setForeground(Colors.TEXT_PRIMARY);

        // ---------------- ANSWER ----------------

        answerArea = new JTextArea(6,40);
        answerArea.setFont(Theme.BODY_FONT);

        // ---------------- FEEDBACK ----------------

        feedbackArea = new JTextArea(10,40);
        feedbackArea.setEditable(false);
        feedbackArea.setFont(Theme.BODY_FONT);
        feedbackArea.setBackground(Colors.BACKGROUND);
        feedbackArea.setForeground(Colors.TEXT_PRIMARY);

        JPanel centerPanel = new JPanel(new BorderLayout(10,10));
        centerPanel.setBackground(Colors.BACKGROUND);

        centerPanel.add(new JScrollPane(questionArea), BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(answerArea), BorderLayout.CENTER);
        centerPanel.add(new JScrollPane(feedbackArea), BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        questionArea.setText("""
Welcome to CampusAI Interview Practice

Choose Domain
Choose Difficulty

Click Start Interview
""");

        // ---------------- BUTTONS ----------------

        startButton.addActionListener(e -> {

            currentQuestion = 0;
            answerArea.setText("");
            feedbackArea.setText("");

            showQuestion();

        });

        nextButton.addActionListener(e -> {

            currentQuestion++;

            answerArea.setText("");
            feedbackArea.setText("");

            showQuestion();

        });

        evaluateButton.addActionListener(e -> evaluateAnswer());

    }

    // ------------------------------------------------

    private void showQuestion() {

        String domain = (String) domainBox.getSelectedItem();

        String[] questions;

        switch(domain){

            case "AI & ML":
                questions = aiQuestions;
                break;

            case "Data Science":
                questions = dsQuestions;
                break;

            default:
                questions = javaQuestions;
        }

        if(currentQuestion >= questions.length)
            currentQuestion = 0;

        questionArea.setText(
                "Question " + (currentQuestion+1) + "\n\n" +
                questions[currentQuestion]
        );

    }

    // ------------------------------------------------

    private void evaluateAnswer(){

        String answer = answerArea.getText().toLowerCase();

        int score = 0;

        if(answer.length() > 40)
            score += 20;

        if(answer.contains("java"))
            score += 10;

        if(answer.contains("python"))
            score += 10;

        if(answer.contains("class"))
            score += 10;

        if(answer.contains("object"))
            score += 10;

        if(answer.contains("machine"))
            score += 10;

        if(answer.contains("learning"))
            score += 10;

        if(answer.contains("data"))
            score += 10;

        if(answer.contains("algorithm"))
            score += 10;

        String grade;

        if(score >= 90)
            grade = "Excellent";

        else if(score >= 75)
            grade = "Very Good";

        else if(score >= 60)
            grade = "Good";

        else if(score >= 40)
            grade = "Average";

        else
            grade = "Needs Improvement";

        feedbackArea.setText(

                "=========== RESULT ===========\n\n" +

                "Interview Score : " + score + "/100\n\n" +

                "Performance : " + grade +

                "\n\n----------------------------------\n\n" +

                "Feedback\n\n" +

                "✔ Try explaining in simple language.\n" +
                "✔ Give one real-world example.\n" +
                "✔ Mention technical keywords.\n" +
                "✔ Maintain confidence.\n\n" +

                "----------------------------------\n\n" +

                "Sample Answer\n\n" +

                "A good interview answer should clearly explain the concept, include technical terms, provide a practical example, and conclude confidently."

        );

    }

}