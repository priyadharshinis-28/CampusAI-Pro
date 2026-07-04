import javax.swing.*;
import java.awt.*;

public class JapanMode extends JPanel {

    private JComboBox<String> jlptBox;
    private JComboBox<String> careerBox;
    private JTextArea resultArea;

    public JapanMode() {

        setLayout(new BorderLayout(15,15));
        setBackground(Colors.BACKGROUND);

        JLabel title = new JLabel("Japan Career Hub");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Colors.TEXT_PRIMARY);
        title.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));

        add(title, BorderLayout.NORTH);

        JPanel left = new JPanel();
        left.setLayout(new GridLayout(12,1,8,8));
        left.setBackground(Colors.BACKGROUND);
        left.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        jlptBox = new JComboBox<>(new String[]{
                "N5","N4","N3","N2","N1"
        });

        careerBox = new JComboBox<>(new String[]{
                "Software Engineer",
                "AI Engineer",
                "Data Scientist",
                "Full Stack Developer",
                "Research Engineer"
        });

        JButton roadmapBtn = new JButton("Roadmap");
        JButton vocabBtn = new JButton("Vocabulary");
        JButton hiraBtn = new JButton("Hiragana");
        JButton kataBtn = new JButton("Katakana");
        JButton kanjiBtn = new JButton("Basic Kanji");
        JButton quizBtn = new JButton("JLPT Quiz");
        JButton companyBtn = new JButton("Japan IT");
        JButton resumeBtn = new JButton("Resume Tips");
        JButton interviewBtn = new JButton("Interview Tips");

        left.add(new JLabel("JLPT Level"));
        left.add(jlptBox);

        left.add(new JLabel("Career Goal"));
        left.add(careerBox);

        left.add(roadmapBtn);
        left.add(vocabBtn);
        left.add(hiraBtn);
        left.add(kataBtn);
        left.add(kanjiBtn);
        left.add(quizBtn);
        left.add(companyBtn);
        left.add(resumeBtn);
        left.add(interviewBtn);

        add(left, BorderLayout.WEST);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font("Yu Gothic UI", Font.PLAIN,16));

        resultArea.setText("""
Welcome to Japan Career Hub

Features

• JLPT Roadmap
• Hiragana
• Katakana
• Kanji
• Vocabulary
• JLPT Quiz
• Japan IT Companies
• Resume Tips
• Interview Tips

Select any option from the left.
""");

        add(new JScrollPane(resultArea),BorderLayout.CENTER);

        roadmapBtn.addActionListener(e->showRoadmap());
        vocabBtn.addActionListener(e->showVocabulary());
        hiraBtn.addActionListener(e->showHiragana());
        kataBtn.addActionListener(e->showKatakana());
        kanjiBtn.addActionListener(e->showKanji());
        quizBtn.addActionListener(e->showQuiz());
        companyBtn.addActionListener(e->showCompanies());
        resumeBtn.addActionListener(e->showResume());
        interviewBtn.addActionListener(e->showInterviewTips());
    }
        private void showRoadmap() {

    String level = (String) jlptBox.getSelectedItem();
    String career = (String) careerBox.getSelectedItem();
    DashboardData.setJlptLevel(level);

    resultArea.setText(
            "========== JAPAN CAREER ROADMAP ==========\n\n" +

            "Current JLPT Level : " + level + "\n\n" +

            "Career Goal : " + career + "\n\n" +

            "Step 1 : Master Hiragana\n" +
            "Step 2 : Master Katakana\n" +
            "Step 3 : Learn 1000+ Vocabulary\n" +
            "Step 4 : Learn Grammar\n" +
            "Step 5 : Practice Listening\n" +
            "Step 6 : Practice Speaking\n" +
            "Step 7 : Pass JLPT " + level + "\n" +
            "Step 8 : Build Java & AI Projects\n" +
            "Step 9 : Build GitHub Portfolio\n" +
            "Step 10 : Apply for Japanese Companies\n\n" +

            "Goal : Work in Japan as a Software Engineer."
    );
        }

        private void showVocabulary() {

        resultArea.setText("""
        ============================
        JLPT N5 Vocabulary
        ============================

        こんにちは  (Konnichiwa)
        Meaning : Hello

        ありがとう  (Arigatou)
        Meaning : Thank You

        おはよう  (Ohayou)
        Meaning : Good Morning

        こんばんは  (Konbanwa)
        Meaning : Good Evening

        さようなら  (Sayounara)
        Meaning : Goodbye

        学校  (Gakkou)
        Meaning : School

        先生  (Sensei)
        Meaning : Teacher

        学生  (Gakusei)
        Meaning : Student

        友達  (Tomodachi)
        Meaning : Friend

        家族  (Kazoku)
        Meaning : Family

        水  (Mizu)
        Meaning : Water

        食べる  (Taberu)
        Meaning : Eat

        飲む  (Nomu)
        Meaning : Drink

        行く  (Iku)
        Meaning : Go

        来る  (Kuru)
        Meaning : Come

        見る  (Miru)
        Meaning : See

        聞く  (Kiku)
        Meaning : Listen

        話す  (Hanasu)
        Meaning : Speak

        読む  (Yomu)
        Meaning : Read

        書く  (Kaku)
        Meaning : Write

        Daily Goal

        Learn 10 words every day.
        """);
        }

        private void showHiragana() {

        resultArea.setText("""
        ============================
        HIRAGANA
        ============================

        あ  a
        い  i
        う  u
        え  e
        お  o

        か  ka
        き  ki
        く  ku
        け  ke
        こ  ko

        さ  sa
        し  shi
        す  su
        せ  se
        そ  so

        た  ta
        ち  chi
        つ  tsu
        て  te
        と  to

        な  na
        に  ni
        ぬ  nu
        ね  ne
        の  no

        Practice writing these daily.
        """);
        }

        private void showKatakana() {

        resultArea.setText("""
        ============================
        KATAKANA
        ============================

        ア  a
        イ  i
        ウ  u
        エ  e
        オ  o

        カ  ka
        キ  ki
        ク  ku
        ケ  ke
        コ  ko

        サ  sa
        シ  shi
        ス  su
        セ  se
        ソ  so

        タ  ta
        チ  chi
        ツ  tsu
        テ  te
        ト  to

        ナ  na
        ニ  ni
        ヌ  nu
        ネ  ne
        ノ  no

        Used mainly for foreign words.
        """);
        }

        private void showKanji() {

        resultArea.setText("""
        ============================
        BASIC KANJI
        ============================

        日
        Sun / Day

        月
        Moon / Month

        火
        Fire

        水
        Water

        木
        Tree

        金
        Gold / Money

        土
        Earth

        山
        Mountain

        川
        River

        人
        Person

        Learn at least 5 Kanji every week.
        """);
        }
        private void showQuiz() {

        String answer = JOptionPane.showInputDialog(
                this,
                "What is the meaning of 'Arigatou'?\n\n" +
                "A. Goodbye\n" +
                "B. Thank You\n" +
                "C. Hello\n" +
                "D. Water"
        );

        if (answer == null)
                return;

        answer = answer.trim().toUpperCase();

        if (answer.equals("B")) {
                DashboardData.setJlptProgress(100);

                resultArea.setText("""
        ============================
        JLPT QUIZ
        ============================

        Correct!

        Arigatou = Thank You

        Score : 100%

        Keep practicing every day!
        """);

        } else {
                DashboardData.setJlptProgress(0);
                resultArea.setText("""
        ============================
        JLPT QUIZ
        ============================

        Wrong Answer.

        Correct Answer : B

        Arigatou = Thank You

        Try Again Tomorrow!
        """);
        }
        NavigationController.showScreen("Dashboard");
        NavigationController.showScreen("Japan Mode");
        }

        private void showCompanies() {

        resultArea.setText("""
        ============================
        TOP JAPANESE IT COMPANIES
        ============================

        1. Rakuten
        E-commerce & FinTech

        2. LINE Yahoo
        Internet Services

        3. Mercari
        E-commerce Platform

        4. Sony
        Electronics & AI

        5. Fujitsu
        Software & Cloud

        6. NEC
        Networking & AI

        7. Hitachi
        AI & Digital Solutions

        8. NTT DATA
        IT Services

        Skills Required

        • Java
        • Python
        • SQL
        • Spring Boot
        • Cloud
        • Japanese (JLPT N3/N2)
        """);
        }

        private void showResume() {

        resultArea.setText("""
        ============================
        RESUME TIPS
        ============================

        Keep Resume 1 Page

        Include

        • Education
        • Technical Skills
        • Projects
        • Internships
        • Certifications
        • GitHub
        • LinkedIn

        Important

        Mention your JLPT level.

        Highlight Java, AI,
        Machine Learning,
        Data Science projects.

        Keep Resume Simple
        and Professional.
        """);
        }

        private void showInterviewTips() {

        resultArea.setText("""
        ============================
        INTERVIEW PREPARATION
        ============================

        Technical Round

        • Java
        • OOP
        • DSA
        • SQL
        • DBMS
        • Operating System

        HR Round

        Tell me about yourself

        Why Japan?

        Strengths

        Weaknesses

        Future Goal

        Behavior

        Be polite.

        Maintain eye contact.

        Answer confidently.

        Say Thank You at the end.
        """);
                
        }


       }

        
