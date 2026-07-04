import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.HashMap;

public class VoiceAssistant extends JPanel {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton speakButton;
    private JButton micButton;
    private JButton askButton;

    private String userName = "User";
    private String lastCommand = "";
    private HashMap<String, String> memory = new HashMap<>();

    public VoiceAssistant() {

        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("🎤 CampusAI JARVIS Voice Assistant");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(5, 5));

        inputField = new JTextField();
        bottom.add(inputField, BorderLayout.CENTER);

        JPanel buttons = new JPanel();

        speakButton = new JButton("🔊 Speak");
        micButton = new JButton("🎙 Mic");
        askButton = new JButton("Ask");

        buttons.add(speakButton);
        buttons.add(micButton);
        buttons.add(askButton);

        bottom.add(buttons, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);

        speakButton.addActionListener(e -> speakText());
        askButton.addActionListener(e -> processCommand(inputField.getText()));
        micButton.addActionListener(e -> simulateMicInput());
    }

    // ---------------- TEXT TO SPEECH ----------------
    private void speak(String text) {
        try {
            String cmd =
                    "PowerShell -Command \"Add-Type –AssemblyName System.Speech; " +
                    "(New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('" + text + "');\"";

            Runtime.getRuntime().exec(cmd);

        } catch (Exception e) {
            chatArea.append("Voice error\n");
        }
    }

    // ---------------- INPUT HANDLER ----------------
    private void speakText() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        chatArea.append("You: " + text + "\n");

        processCommand(text);

        inputField.setText("");
    }

    // ---------------- MIC SIMULATION ----------------
    private void simulateMicInput() {
        JOptionPane.showMessageDialog(this,
                "🎙 Mic feature is currently simulated.\nType your command and press Ask.");

        inputField.requestFocus();
    }

    // ---------------- COMMAND PROCESSOR ----------------
    private void processCommand(String cmdRaw) {

        String cmd = cmdRaw.toLowerCase().trim();
        if (cmd.isEmpty()) return;

        chatArea.append("You: " + cmd + "\n");

        lastCommand = cmd;

        // Save name
        if (cmd.contains("my name is")) {
            userName = cmd.replace("my name is", "").trim();
            memory.put("name", userName);
            respond("Nice to meet you " + userName);
            return;
        }

        // Time
        if (cmd.contains("time")) {
            respond("Current time is " + LocalTime.now());
            return;
        }

        // Study
        if (cmd.contains("study")) {
            respond("Opening Study Planner...");
            openModule("study");
            return;
        }

        // GPA
        if (cmd.contains("gpa")) {
            respond("Opening GPA Calculator...");
            openModule("gpa");
            return;
        }

        // Japan
        if (cmd.contains("japan")) {
            respond("Opening Japan Career Hub...");
            openModule("japan");
            return;
        }

        // Notes
        if (cmd.contains("note")) {
            respond("Opening Notes Manager...");
            openModule("notes");
            return;
        }

        // Greeting
        if (cmd.contains("hello")) {
            respond("Hello " + userName + "! How can I help you?");
            return;
        }

        // Default fallback
        respond("I am still learning. Try: study, gpa, japan, notes, time.");
    }

    // ---------------- AI RESPONSE ----------------
    private void respond(String msg) {
        chatArea.append("AI: " + msg + "\n\n");
        speak(msg);
    }

    // ---------------- MODULE CONNECTOR ----------------
    private void openModule(String module) {

        switch (module) {

            case "study":
                chatArea.append("[System] Study Planner triggered\n");
                break;

            case "gpa":
                chatArea.append("[System] GPA Calculator triggered\n");
                break;

            case "japan":
                chatArea.append("[System] Japan Mode triggered\n");
                break;

            case "notes":
                chatArea.append("[System] Notes Manager triggered\n");
                break;
        }
    }
}