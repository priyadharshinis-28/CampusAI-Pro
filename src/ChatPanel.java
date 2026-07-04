import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {

    private JPanel messagesPanel;
    private JScrollPane scrollPane;
    private JButton clearBtn;

    public ChatPanel() {

        setLayout(new BorderLayout());
        setBackground(Colors.BACKGROUND);

        // ---------------- MESSAGES PANEL ----------------
        messagesPanel = new JPanel();
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        messagesPanel.setBackground(Colors.BACKGROUND);

        scrollPane = new JScrollPane(messagesPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Colors.BACKGROUND);
        scrollPane.getVerticalScrollBar().setUnitIncrement(18);

        add(scrollPane, BorderLayout.CENTER);

        // ---------------- CLEAR BUTTON ----------------
        clearBtn = new JButton("🧹 Clear Chat");

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(Colors.BACKGROUND);
        topPanel.add(clearBtn);

        add(topPanel, BorderLayout.NORTH);

        // ---------------- LOAD HISTORY ----------------
        loadHistory();

        // ---------------- WELCOME MESSAGE ----------------
        if (ChatHistory.loadMessages().isEmpty()) {
            addMessage("👋 Welcome to CampusAI Pro!\nHow can I help you today?", false, false);
        }

        // ---------------- CLEAR ACTION (FIXED) ----------------
        clearBtn.addActionListener(e -> clearChat());
    }

    // ---------------- ADD MESSAGE ----------------
    public void addMessage(String text, boolean isUser) {
        addMessage(text, isUser, true);
    }

    public void addMessage(String text, boolean isUser, boolean save) {

        ChatBubble bubble = new ChatBubble(text, isUser);

        messagesPanel.add(bubble);
        messagesPanel.add(Box.createVerticalStrut(12));

        messagesPanel.revalidate();
        messagesPanel.repaint();

        SwingUtilities.invokeLater(() -> {
            JScrollBar bar = scrollPane.getVerticalScrollBar();
            bar.setValue(bar.getMaximum());
        });

        // ---------------- SAVE TO HISTORY ----------------
        if (save) {
            String role = isUser ? "USER" : "AI";
            ChatHistory.saveMessage(role + ":" + text);
        }
    }

    // ---------------- LOAD HISTORY ----------------
    public void loadHistory() {

        for (String msg : ChatHistory.loadMessages()) {

            boolean isUser = msg.startsWith("USER:");

            String text = msg.replaceFirst("USER:|AI:", "").trim();

            ChatBubble bubble = new ChatBubble(text, isUser);

            messagesPanel.add(bubble);
            messagesPanel.add(Box.createVerticalStrut(12));
        }
    }

    // ---------------- CLEAR CHAT (FIXED) ----------------
    public void clearChat() {

        // clear UI
        messagesPanel.removeAll();
        messagesPanel.revalidate();
        messagesPanel.repaint();

        // clear file
        ChatHistory.clearHistory();

        // optional message
        addMessage("Chat cleared successfully.", false, false);
    }
}