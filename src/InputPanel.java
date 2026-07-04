import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InputPanel extends JPanel {

    private JTextField inputField;
    private RoundedButton sendButton;
    private ChatPanel chatPanel;

    public InputPanel(ChatPanel chatPanel) {

        this.chatPanel = chatPanel;

        setLayout(new BorderLayout(10, 0));
        setBackground(Colors.HEADER);
        setBorder(new EmptyBorder(12, 15, 12, 15));

        inputField = new JTextField();
        inputField.setFont(Theme.CHAT_FONT);
        inputField.setBackground(Colors.CARD);
        inputField.setForeground(Colors.TEXT_PRIMARY);
        inputField.setCaretColor(Colors.TEXT_PRIMARY);
        inputField.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        sendButton = new RoundedButton("➤");
        sendButton.setPreferredSize(new Dimension(60, 45));

        sendButton.addActionListener(e -> sendMessage());

        inputField.addActionListener(e -> sendMessage());

        add(inputField, BorderLayout.CENTER);
        add(sendButton, BorderLayout.EAST);
    }

    private void sendMessage() {

        String text = inputField.getText().trim();

        if (text.isEmpty())
            return;

        chatPanel.addMessage(text, true);
        ProductivityTracker.questionAsked();

        String reply = ChatEngine.getResponse(text);

        chatPanel.addMessage(reply, false);

        inputField.setText("");
        inputField.requestFocus();
    }
}