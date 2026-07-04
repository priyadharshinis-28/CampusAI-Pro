import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatBubble extends JPanel {

    public ChatBubble(String message, boolean isUser) {

        setLayout(new FlowLayout(isUser ? FlowLayout.RIGHT : FlowLayout.LEFT));
        setOpaque(false);

        JPanel bubble = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                g2.dispose();

                super.paintComponent(g);
            }
        };

        bubble.setOpaque(false);
        bubble.setBackground(isUser ? Colors.USER_BUBBLE : Colors.AI_BUBBLE);
        bubble.setLayout(new BorderLayout());
        bubble.setBorder(new EmptyBorder(12,16,12,16));

        JTextArea text = new JTextArea(message);
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setEditable(false);
        text.setOpaque(false);
        text.setFocusable(false);
        text.setForeground(Colors.TEXT_PRIMARY);
        text.setFont(Theme.CHAT_FONT);

        text.setMaximumSize(new Dimension(
                Theme.CHAT_BUBBLE_WIDTH,
                Integer.MAX_VALUE));

        bubble.add(text);

        add(bubble);
    }
}