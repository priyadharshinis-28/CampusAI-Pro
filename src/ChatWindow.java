import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JPanel {

    public ChatWindow() {

        setLayout(new BorderLayout());
        setBackground(Colors.BACKGROUND);

        ChatPanel chatPanel = new ChatPanel();
        InputPanel inputPanel = new InputPanel(chatPanel);

        add(chatPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }
}